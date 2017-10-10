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

    private final int id;
    private final int længde;
    private final int bredde;
    private final int højde;
    private final Date date;
    private boolean shipped;
    private final User user;

    public Order(User user, int id, int længde, int bredde, int højde, boolean shipped, String date) {
        this.id = id;
        this.user = user;
        this.længde = længde;
        this.bredde = bredde;
        this.højde = højde;
        this.shipped = false;
        this.date = new Date();
    }

    public User getUser() {
        return user;
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
