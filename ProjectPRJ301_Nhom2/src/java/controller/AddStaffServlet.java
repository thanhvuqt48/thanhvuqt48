/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;
import model.Account;

/**
 *
 * @author DELL
 */
@WebServlet(name="AddStaffServlet", urlPatterns={"/addstaff"})
public class AddStaffServlet extends HttpServlet {
   
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
            out.println("<title>Servlet AddStaffServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddStaffServlet at " + request.getContextPath () + "</h1>");
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
        request.getRequestDispatcher("./StaffManager/newstaff.jsp").forward(request, response);
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
        String username = request.getParameter("username");
        String phonenumber = request.getParameter("phonenumber");
        String fullname = request.getParameter("fullname");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String address = request.getParameter("address");
        AccountDAO cdb = new AccountDAO();
        Account c = cdb.getAccountByUsername(username);
         Pattern pattern = Pattern.compile("^[a-zA-Z0-9_-]*$");
        
        if ( c != null){
            String ms = "Username has already existed";
            request.setAttribute("error", ms);
            request.getRequestDispatcher("./StaffManager/newstaff.jsp").forward(request, response);
        } else if (!pattern.matcher(username).find()) {
            String ms = "Username must only contain letters, numbers and - and _";
            request.setAttribute("error", ms);
            request.getRequestDispatcher("./StaffManager/newstaff.jsp").forward(request, response);
        }  else if(phonenumber.length() != 10){   //tại vì sđt ngắn nhất thế giới là Vatican chỉ có 6 chữ số
            String ms = "Phone number is wrong";
            request.setAttribute("error", ms);
            request.getRequestDispatcher("./StaffManager/newstaff.jsp").forward(request, response);
        } else if (!password.equals(repassword)){
            String ms = "Re-password not same password";
            request.setAttribute("error", ms);
            request.getRequestDispatcher("./StaffManager/newstaff.jsp").forward(request, response);
        } else{
            Account newAccount = new Account(username, phonenumber, password, address, fullname);
            cdb.newAccountStaff(newAccount);
            response.sendRedirect("./Account/admin.jsp");
        }
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
