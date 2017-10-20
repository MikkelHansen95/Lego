/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.LegoStykliste;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mikkel Lindstrøm
 */
public class doStykliste extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        
        int længde = Integer.parseInt(request.getParameter("length"));
        int bredde = Integer.parseInt(request.getParameter("width"));
        int højde = Integer.parseInt(request.getParameter("heigth")); 
        LegoStykliste LegoStyklist = Render.stykListe(længde, bredde, højde);
        session.setAttribute("LegoStyklist", LegoStyklist);
        
        return "styklistepage";
    }

}
