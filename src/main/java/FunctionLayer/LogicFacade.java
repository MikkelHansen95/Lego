package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The purpose of LogicFacade is to...
 *
 * @author kasper
 */
public class LogicFacade {

    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }

    public static Order createOrderFromDB(int id, int userID, int længde, int bredde, int højde, String date, int shipped, String shippingDate) throws LoginSampleException {
        Order order = new Order(id, userID, længde, bredde, højde, date, shipped, shippingDate);
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

    public static void setShipStatus(int oid) throws LoginSampleException {
            OrderMapper.updateShippingStatus(oid);
            OrderMapper.updateShippingDate(oid);
    }


}
