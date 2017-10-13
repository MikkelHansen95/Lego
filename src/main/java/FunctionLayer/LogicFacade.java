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
    public static Order createOrder(int userID, int id, int længde, int bredde, int højde, Date date, boolean shipped) throws LoginSampleException {
        Order order = new Order(userID,id,længde,bredde,højde,date,shipped);
        OrderMapper.createOrderInDB(order);
        return order;
    }
     public static Order createOrder(int userID, int længde, int bredde, int højde) throws LoginSampleException {
        Order order = new Order(userID, længde, bredde, højde);
        OrderMapper.createOrderInDB(order);
        return order;
    }

}
