package FunctionLayer;

import java.util.ArrayList;

/**
 * The purpose of User is to...
 *
 * @author kasper
 */
public class User {

    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.orderList = orderList;
    }

    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private final String email;
    private final String password; // Should be hashed and all
    private final String role;
    private ArrayList<Order> orderList;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public int getID() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void addToOrderList(Order order) {
        this.orderList.add(order);
    }    

}
