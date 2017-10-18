/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.Date;

/**
 *
 * @author Mikkel Lindstrøm
 */
public class Order {

    private int id;
    private final int længde;
    private final int bredde;
    private final int højde;
    private Date date;
    private int shipped;
    private final int userID;
    private Date shippingDate;
    
    public Order (int userID, int længde, int bredde, int højde){
        this.userID = userID;
        this.længde = længde;
        this.bredde = bredde;
        this.højde = højde;
        this.shipped = 0;
        this.date = new Date();
        this.shippingDate = null;
    }
    
    
    
    public Order(int id, int userID,int længde, int bredde, int højde, Date date, int shipped, Date shippingDate) {
        this.id = id;
        this.længde = længde;
        this.bredde = bredde;
        this.højde = højde;
        this.shipped = shipped;
        this.date = date;
        this.userID = userID;
        this.shippingDate = shippingDate;
    }

    public Date setShippingDate() {
        date = new Date();
        return date;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return userID;
    }

    public int isShipped() {
        return shipped;
    }

    public void setShipped(int shipped) {
        this.shipped = shipped;
    }

    public Date getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public int getLængde() {
        return længde;
    }

    public int getBredde() {
        return bredde;
    }

    public int getHøjde() {
        return højde;
    }
    
}
