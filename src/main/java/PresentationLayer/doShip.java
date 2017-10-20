/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mikkel Lindstrøm
 */
public class doShip extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        int oid = Integer.parseInt(request.getParameter("oid"));
        LogicFacade.setShipStatus(oid);
//        session.setAttribute("orderId", oid);
        Order order = OrderMapper.getSingleOrderFromId(oid);
        order.setShippingDate();
        OrderMapper.getOrderListAll();
        return "employeepage";

    }
}
