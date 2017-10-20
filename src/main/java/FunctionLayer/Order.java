/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Mikkel Lindstrøm
 */
public class Order {

    private int oid;
    private final int længde;
    private final int bredde;
    private final int højde;
    private String date;
    private int shipped;
    private final int userID;
    private String shippingDate;

    public Order(int userID, int længde, int bredde, int højde) {
        this.userID = userID;
        this.længde = længde;
        this.bredde = bredde;
        this.højde = højde;
        this.shipped = 0;
        this.date = setDate();
        this.shippingDate = shippingDate;
    }

    public Order(int oid, int userID, int længde, int bredde, int højde, String date, int shipped, String shippingDate) {
        this.oid = oid;
        this.længde = længde;
        this.bredde = bredde;
        this.højde = højde;
        this.shipped = shipped;
        this.date = date;
        this.userID = userID;
        this.shippingDate = shippingDate;
    }

    public String setShippingDate() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date datedate = new Date();
        String shippingDate = df.format(datedate);
        return shippingDate;
    }

    public String setDate() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date datedate = new Date();
        String date = df.format(datedate);
        return date;
    }

    public String getShippingDate() {
        return shippingDate;
    }

    public void setId(int id) {
        this.oid = id;
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

    public String getDate() {
        return date;
    }

    public int getId() {
        return oid;
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
