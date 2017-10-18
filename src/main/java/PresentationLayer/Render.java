/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Order;
import java.util.ArrayList;
import java.util.Date;

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
                    + "<th>" + order.getDate() + "</th>";

            if (order.isShipped() == 0) {
                output += "<th>" + "Not Shipped yet" + "</th>";

            } else {
                output += "<th>" + order.getShippingDate() + "</th>";
            }
            output += "</tr>";
        }
        return output;

    }

    public static String viewUserOrderListEmp(ArrayList<Order> orderList) {

        String output = "";
        for (Order order : orderList) {
            output += "<tr>"
                    + "<th>" + order.getUser() + "</th>"
                    + "<th>" + order.getId() + "</th>"
                    + "<th>" + order.getLængde() + "</th>"
                    + "<th>" + order.getBredde() + "</th>"
                    + "<th>" + order.getHøjde() + "</th>"
                    + "<th>" + order.getDate() + "</th>";

            if (order.isShipped() == 0) {
                output += "<th>" 
                        + "<form action=" + "FrontController " + "method=" + "POST" + "> "
                        + "<input type=" + "hidden" + " name=" + "command" + " value=" + "doShip" + ">"
                        + "<input type=" + "hidden" + " name=" + "orderId" + " value=" + order.getId() + ">"
                        + "<input type=" + "submit" + " name=" + "shipped" + " value=" + "Ship Order" + ">"
                        + "</form>"
                        + "</th>";

            } else {
                output += "<th>" + order.getShippingDate() + "<th>";
            }

        }

        output += "</tr>";
        return output;

    }

}
