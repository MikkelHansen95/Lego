/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.Date;
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
    
       public static void createOrder( Order order ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO order (id, length, height, width, date, shipped) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setInt( 1, order.getId() );
            ps.setInt( 2, order.getLængde() );
            ps.setInt( 3, order.getHøjde() );
            ps.setInt( 4, order.getBredde() );
            ps.setDate(5, (Date) order.getDate());
            ps.setBoolean( 6, order.isShipped() );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            order.setId( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }
      
          public static Order getOrderListUser(User user) throws LoginSampleException {
        try {
            Order order = null;
            Connection con = Connector.connection();
            String SQL = "SELECT id, length, height, width, date, shipped FROM order "
                    + "WHERE userID="+user.getID();
            PreparedStatement ps = con.prepareStatement( SQL );
            ResultSet rs = ps.executeQuery();
            
            int uId = user.getID();
            int oId = rs.getInt("id");
            int l = rs.getInt("length");
            int h = rs.getInt("height");
            int w = rs.getInt("width");
            Date date = rs.getDate("date");
            boolean shipped = rs.getBoolean("shipped");
            
            
            if ( rs.next() ) {
                order = new Order(uId,oId,l,w,h,date,shipped);
                
               
                return order;
            } else {
                throw new LoginSampleException( "Could not create orderlist" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
       
       
       
    
    
    
    
}
