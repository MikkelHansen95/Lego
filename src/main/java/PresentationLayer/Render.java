/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Order;
import java.util.ArrayList;

/**
 *
 * @author Mikkel Lindstrøm
 */
public class Render {

    public static String viewUserOrderList(ArrayList<Order> orderList) {
        String output = "";
        for (Order order : orderList) {
            output += "<tr>"
                    + "<th>" + order.getId() + "</th>"
                    + "<th>" + order.getUser() + "</th>"
                    + "<th>" + order.getLængde() + "</th>"
                    + "<th>" + order.getBredde() + "</th>"
                    + "<th>" + order.getHøjde() + "</th>"
                    + "<th>" + order.getDate() + "</th>"
                    + "<th>" + order.isShipped() + "</th>";
            output += "</tr>";
        }
        return output;

    }
    
    

}
