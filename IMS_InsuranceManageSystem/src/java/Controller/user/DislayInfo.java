/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.user;

import Dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Model.User;

/**
 *
 * @author Dell
 */
@WebServlet(name="Info_user", urlPatterns={"/DislayInfo"})
public class DislayInfo extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Info_user</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Info_user at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        UserDAO dao = new UserDAO();
        HttpSession session = request.getSession();
        User user1 = (User) session.getAttribute("user");
        User user = dao.dislayInfo(user1.getUser_id());
         
         
         
       response.setContentType("application/json");
        PrintWriter out = response.getWriter();
       out.println("{\"user_id\": \"" + user.getUser_id() + "\", "
               + "\"user_fullname\": \"" + user.getUser_fullName() + "\", \"user_email\": \"" 
               + user.getUser_email() + "\", \"user_password\": \"" + user.getUser_password() 
               + "\", \"user_dob\": \"" + user.getUser_dob() + "\", \"user_address\": \"" 
               + user.getUser_address() + "\", \"user_phoneNum\": \"" + user.getUser_phoneNum() 
               + "\", \"user_iden\": \"" + user.getUser_iden() + "\", \"user_image\": \"" 
               + user.getUser_image() + "\", \"user_role\": \"" 
               + user.getUser_role() + "\"}");

    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
