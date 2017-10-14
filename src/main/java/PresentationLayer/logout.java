/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mikkel Lindstrøm
 */
public class logout extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        HttpSession session = request.getSession();
        User user = null;
        session.setAttribute( "user", user );
        return "../index";
    }
    
}
