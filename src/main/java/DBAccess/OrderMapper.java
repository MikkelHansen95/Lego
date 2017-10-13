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
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mikkel Lindstrøm
 */
public class OrderMapper {

    public static void createOrderInDB(Order order) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO order (id, userID, length, height, width, date, shipped) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getId());
            ps.setInt(2, order.getUser());
            ps.setInt(3, order.getLængde());
            ps.setInt(4, order.getHøjde());
            ps.setInt(5, order.getBredde());
            String dateStr = fromJavaToSQLDate(order.getDate());
            ps.setString(6, dateStr);
            ps.setBoolean(7, order.isShipped());
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
            String SQL = "SELECT id, userID, length, height, width, date, shipped FROM order "
                    + "WHERE userID=" + user.getID();
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int orderId = rs.getInt("id");
                int userId = rs.getInt("userID");
                user = UserMapper.getUser(userId);
                int length = rs.getInt("length");
                int height = rs.getInt("height");
                int width = rs.getInt("width");
                Date date = rs.getDate("date");
                boolean shipped = rs.getBoolean("shipped");

                order = LogicFacade.createOrder(user.getID(), orderId, length, width, height, date, shipped);
                createOrderInDB(order);
                user.addToOrderList(order);

                return user;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return user;
    }

     private static String fromJavaToSQLDate(Date date) {
        java.text.SimpleDateFormat sdf
                = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(date);
        return currentTime;
    }

}
