/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.Order;
import FunctionLayer.Stykliste;
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
                        + "<form action=" + "FrontController " + "method=" + "POST" + ">"
                        + "<input type=" + "hidden" + " name=" + "command" + " value=" + "doShip" + ">"
                        + "<input type=\"hidden\" name=\"orderId\" value=\"" + order.getId()+"\">"
                        + "<input type=" + "submit" + " name=" + "shipped" + " value=" + "Ship Order" + ">"
                        + "</form>"
                        + "</th>";

            } else {
                output += "<th>" + order.getShippingDate() + "<th>";
            }

             output += "<th>"
                        + "<form action=" + "FrontController " + "method=" + "POST" + ">"
                        + "<input type=" + "hidden" + " name=" + "command" + " value=" + "doStykliste" + ">"
                        + "<input type=\"hidden\" name=\"length\" value=\"" + order.getLængde() +"\">"
                        + "<input type=\"hidden\" name=\"width\" value=\"" + order.getBredde()+"\">"  
                        + "<input type=\"hidden\" name=\"heigth\" value=\"" + order.getHøjde()+"\">"
                        + "<input type=" + "submit" + " name=" + "stykliste" + " value=" + "stykliste" + ">"
                        + "</form>"
                        + "</th>";
            
            
        }

        output += "</tr>";
        return output;

    }

    public static Stykliste stykListe(Order order) {

        int bredde = order.getBredde();
        int længde = order.getLængde();
        int højde = order.getHøjde();

        int fireklodser = 0, toklodser = 0, enkeltklods = 0, rest4 = 0, rest2 = 0;
        int bredde4klods = 0, bredde2klods = 0, bredde1klods = 0, brest4 = 0, brest2 = 0;

        for (int i = 1; i < højde; i++) {

            if (højde % 2 == 0) {
                fireklodser += (længde - 4) / 4;
                rest4 = (længde - 4) % 4;
                toklodser += rest4 / 2;
                rest2 = rest4 % 2;
                enkeltklods += rest2 / 1;

                bredde4klods += bredde / 4;
                brest4 = bredde % 4;
                bredde2klods += brest4 / 2;
                brest2 = brest4 % 2;
                bredde1klods += brest2;

            } else {
                fireklodser += længde / 4;
                rest4 = længde % 4;
                toklodser += rest4 / 2;
                rest2 = rest4 % 2;
                enkeltklods += rest2 / 1;

                bredde4klods += (bredde - 4) / 4;
                brest4 = (bredde - 4) % 4;
                bredde2klods += brest4 / 2;
                brest2 = brest4 % 2;
                bredde1klods += brest2;
            }

            fireklodser = fireklodser * 2;
            toklodser = toklodser * 2;
            enkeltklods = enkeltklods * 2;
            bredde4klods = bredde4klods * 2;
            bredde2klods = bredde2klods * 2;
            bredde1klods = bredde1klods * 2;

        }

        Stykliste stykliste = LogicFacade.createStykliste((fireklodser + bredde4klods),
                (toklodser + bredde2klods), (enkeltklods + bredde1klods));

        return stykliste;
    }

}
