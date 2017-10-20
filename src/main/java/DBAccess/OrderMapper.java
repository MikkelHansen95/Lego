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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Mikkel Lindstrøm
 */
public class OrderMapper {

    public static void createOrderInDB(Order order) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (userID, length, height, width, date, shipped, shippingDate) VALUES (?, ?, ?, ?, ?, ?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getUser());
            ps.setInt(2, order.getLængde());
            ps.setInt(3, order.getBredde());
            ps.setInt(4, order.getHøjde());
            ps.setString(5, order.setDate());
            ps.setInt(6, order.isShipped());
            ps.setString(7, order.getShippingDate());
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
                String date = rs.getString("date");
                int shipped = rs.getInt("shipped");
                String shipDate = rs.getString("shippingDate");
                order = LogicFacade.createOrderFromDB(orderId, userId, length, width, height, date, shipped, shipDate);
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
                String date = rs.getString("date");
                int shipped = rs.getInt("shipped");
                String shippingDate = rs.getString("shippingDate");

                order = LogicFacade.createOrderFromDB(orderId, userId, length, width, height, date, shipped, shippingDate);
                orderListAll.add(order);
                order = null;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }

        return orderListAll;
    }

    public static Order getSingleOrderFromId(int oid) throws LoginSampleException {
        Order order = null;
        try {

            Connection con = Connector.connection();
            String SQL = "SELECT * FROM orders WHERE id=" + oid;
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int orderId = rs.getInt("id");
                int userId = rs.getInt("userID");
                int length = rs.getInt("length");
                int height = rs.getInt("height");
                int width = rs.getInt("width");
                String date = rs.getString("date");
                int shipped = rs.getInt("shipped");
                String shippingDate = rs.getString("shippingDate");

                order = LogicFacade.createOrderFromDB(userId, orderId, length, width, height, date, shipped, shippingDate);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }

        return order;
    }

    public static void updateShippingStatus(int oid) throws LoginSampleException{
        try {
            Connection con = Connector.connection();
            int ship = 1;
            String SQL = "UPDATE orders SET shipped = ? WHERE id =?";
            try (
                PreparedStatement ps = con.prepareStatement(SQL)) {
                ps.setInt(1,ship);
                ps.setInt(2, oid);
                ps.executeUpdate();
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static void updateShippingDate(int oid) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE orders SET shippingDate = ? WHERE id =" + oid;
            PreparedStatement ps = con.prepareStatement(SQL);
            Order order = OrderMapper.getSingleOrderFromId(oid);
            ps.setString(1, order.setShippingDate());
            ps.executeUpdate();
         } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        }
    }


