package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.Date;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }
    public static Order createOrderFromDB(int id, int userID, int længde, int bredde, int højde, Date date, boolean shipped) throws LoginSampleException {
        Order order = new Order(id,userID,længde,bredde,højde,date,shipped);
        return order;
    }
     public static Order createOrderInDB(int userID, int længde, int bredde, int højde) throws LoginSampleException {
        Order order = new Order(userID, længde, bredde, højde);
        OrderMapper.createOrderInDB(order);
        return order;
    }
      public static User getOrderList(User user) throws LoginSampleException {
        user = OrderMapper.getOrderList(user);
        return user;
    }

}
