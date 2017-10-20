/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Order;
import FunctionLayer.LegoStykliste;
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
                    + "<th>" + order.getDate() + "</th>";

            if (order.isShipped() == 0) {
                output += "<th>" + "Not Shipped yet" + "</th>";

            } else {
                output += "<th>" + order.getShippingDate() + "</th>";
            }
            output += "<th>"
                    + "<form action=" + "FrontController " + "method=" + "POST" + ">"
                    + "<input type=" + "hidden" + " name=" + "command" + " value=" + "doStykliste" + ">"
                    + "<input type=\"hidden\" name=\"length\" value=\"" + order.getLængde() + "\">"
                    + "<input type=\"hidden\" name=\"width\" value=\"" + order.getBredde() + "\">"
                    + "<input type=\"hidden\" name=\"heigth\" value=\"" + order.getHøjde() + "\">"
                    + "<input type=" + "submit" + " name=" + "stykliste" + " value=" + "stykliste" + ">"
                    + "</form>"
                    + "</th>";

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
                        + "<input type=\"hidden\" name=\"oid\" value=\"" + order.getId() + "\">"
                        + "<input type=" + "submit" + " name=" + "shipped" + " value=" + "Ship Order" + ">"
                        + "</form>"
                        + "</th>";
                

            } else {
                output += "<th>" + order.getShippingDate() + "</th>";
            }
            output += "<th>"
                    + "<form action=" + "FrontController " + "method=" + "POST" + ">"
                    + "<input type=" + "hidden" + " name=" + "command" + " value=" + "doStykliste" + ">"
                    + "<input type=\"hidden\" name=\"length\" value=\"" + order.getLængde() + "\">"
                    + "<input type=\"hidden\" name=\"width\" value=\"" + order.getBredde() + "\">"
                    + "<input type=\"hidden\" name=\"heigth\" value=\"" + order.getHøjde() + "\">"
                    + "<input type=" + "submit" + " name=" + "stykliste" + " value=" + "stykliste" + ">"
                    + "</form>"
                    + "</th>";
        }
        output += "</tr>";
        return output;

    }

    public static LegoStykliste stykListe(int længde, int bredde, int højde) {

//        int fireklodser = 0, toklodser = 0, enkeltklods = 0, rest4 = 0, rest2 = 0;
//        int bredde4klods = 0, bredde2klods = 0, bredde1klods = 0, brest4 = 0, brest2 = 0;
        int fireklodserFINAL = 0;
        int toklodserFINAL = 0;
        int enkeltklodsFINAL = 0;

        for (int i = 0; i < højde; i++) {

            int fireklodser = 0, toklodser = 0, enkeltklods = 0, rest4 = 0, rest2 = 0;
            int bredde4klods = 0, bredde2klods = 0, bredde1klods = 0, brest4 = 0, brest2 = 0;

            if ((højde % 2) == 0) {
                fireklodser =  ((længde - 4) / 4);
                rest4 =        ((længde - 4) % 4);
                toklodser =    (rest4 / 2);
                rest2 =        (rest4 % 2);
                enkeltklods =  (rest2 / 1);

                bredde4klods = (bredde / 4);
                brest4 =       (bredde % 4);
                bredde2klods = (brest4 / 2);
                brest2 =       (brest4 % 2);
                bredde1klods = brest2;

            } else {
                fireklodser = (længde / 4);
                rest4 = (længde % 4);
                toklodser = (rest4 / 2);
                rest2 = (rest4 % 2);
                enkeltklods = (rest2 / 1);

                bredde4klods = ((bredde - 4) / 4);
                brest4 = ((bredde - 4) % 4);
                bredde2klods = (brest4 / 2);
                brest2 = (brest4 % 2);
                bredde1klods = brest2;
            }

            fireklodserFINAL += (fireklodser * 2) + (bredde4klods * 2);
            toklodserFINAL += (toklodser * 2) + (bredde2klods * 2);
            enkeltklodsFINAL += (enkeltklods * 2) + (bredde1klods * 2);

        }
        
        if(længde>9 || bredde>9 && højde>3){
            fireklodserFINAL = (fireklodserFINAL-5);
        }
//        int AntalFireKlods = (fireklodser + bredde4klods);
//        int AntalToKlods = (toklodser + bredde2klods);
//        int AntalEnkelsKlods = (enkeltklods + bredde1klods);

        LegoStykliste nyStykListe = new LegoStykliste(fireklodserFINAL, toklodserFINAL, enkeltklodsFINAL);

        return nyStykListe;
    }

}
