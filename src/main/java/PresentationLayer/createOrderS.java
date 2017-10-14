/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mikkel Lindstrøm 
 */
@WebServlet(name = "createOrderS", urlPatterns = {"/createOrderS"})
public class createOrderS extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        try {
            Command action = Command.from( request );
            String view = action.execute( request, response );
            request.getRequestDispatcher( "/WEB-INF/" + view + ".jsp" ).forward( request, response );
        } catch ( LoginSampleException ex ) {
            request.setAttribute( "error", ex.getMessage() );
            request.getRequestDispatcher( "WEB-INF/customerpage.jsp" ).forward( request, response );
        }
    }
    
    
    
    
    
    
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//
//        HttpSession session = request.getSession();
//        User user = (User) (session.getAttribute("user"));
//        
//        int length = Integer.parseInt(request.getParameter("length"));
//        int width = Integer.parseInt(request.getParameter("width"));
//        int height = Integer.parseInt(request.getParameter("heigth"));
//
//        Order order = new Order(user.getID(),length,width,height);
//        try {
//            OrderMapper.createOrderInDB(order);
//            
//            Command action = Command.from( request );
//            String view = action.execute( request, response );
//            request.getRequestDispatcher( "/WEB-INF/customerList.jsp" ).forward( request, response );
//            
//            
//            
//        } catch (LoginSampleException ex) {
//            Logger.getLogger(createOrderS.class.getName()).log(Level.SEVERE, null, ex);
//            
//        }
//        
//    }


// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 * Handles the HTTP <code>GET</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
