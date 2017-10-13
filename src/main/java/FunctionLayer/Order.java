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
    private boolean shipped;
    private final int userID;
    
    public Order (int userID, int længde, int bredde, int højde){
        this.userID = userID;
        this.længde = længde;
        this.bredde = bredde;
        this.højde = højde;
        this.shipped = false;
        this.date = new Date();
    }
    
    
    
    public Order(int id, int userID,int længde, int bredde, int højde, Date date, boolean shipped) {
        this.id = id;
        this.længde = længde;
        this.bredde = bredde;
        this.højde = højde;
        this.shipped = false;
        this.date = date;
        this.userID = userID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return userID;
    }

    public boolean isShipped() {
        return shipped;
    }

    public void setShipped(boolean shipped) {
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
