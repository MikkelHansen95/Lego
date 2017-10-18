/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mikkel Lindstrøm
 */
public class OrderMapper {
    
    private static SimpleDateFormat dt = new SimpleDateFormat("d. MMM yyyy - HH:mm");

    public static void createOrderInDB(Order order) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (userID, length, height, width, date, shipped, shippingDate) VALUES (?, ?, ?, ?, ?, ?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getUser());
            ps.setInt(2, order.getLængde());
            ps.setInt(3, order.getHøjde());
            ps.setInt(4, order.getBredde());
            String dateStr = fromJavaToSQLDate(order.getDate());
            ps.setString(5, dateStr);
            ps.setInt(6, order.isShipped());
            String dateShipStr = fromJavaToSQLDate(order.getShippingDate());
            ps.setString(7, dateShipStr);
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            order.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static User getOrderList(User user) throws LoginSampleException {
        try {
            Order order = null;
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM orders WHERE userID=" + user.getID();
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int orderId = rs.getInt("id");
                int userId = rs.getInt("userID");
                int length = rs.getInt("length");
                int height = rs.getInt("height");
                int width = rs.getInt("width");
                Date date = rs.getTimestamp("date");
                int shipped = rs.getInt("shipped");
                Date shipDate = rs.getTimestamp("shippingDate");
                order = LogicFacade.createOrderFromDB(orderId, userId, length, width, height, date, shipped,shipDate);
                user.addToOrderList(order);

            }
            return user;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }

    }

    public static ArrayList<Order> getOrderListAll() throws LoginSampleException {
        ArrayList<Order> orderListAll = new ArrayList<>();
        try {
            Order order = null;
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM orders";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int orderId = rs.getInt("id");
                int userId = rs.getInt("userID");
                int length = rs.getInt("length");
                int height = rs.getInt("height");
                int width = rs.getInt("width");
                Date date = rs.getTimestamp("date");
                int shipped = rs.getInt("shipped");
                Date shippingDate = rs.getTimestamp("shippingDate");

                order = LogicFacade.createOrderFromDB(userId, orderId, length, width, height, date, shipped, shippingDate);
                orderListAll.add(order);
                order = null;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }

        return orderListAll;
    }

    private static String fromJavaToSQLDate(Date date) {
        java.text.SimpleDateFormat sdf
                = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(date);
        return currentTime;
    }

    public static void updateShipStatus(int orderId) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE orders SET shipped = '1' WHERE id =" + orderId;
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
    
    

}
