/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mikkel Lindstrøm
 */
public class doShip extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        int id = Integer.parseInt(request.getParameter("orderId"));
        
        try {
            LogicFacade.setShipStatus(id);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(doShip.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "employeepage";
    }
}
