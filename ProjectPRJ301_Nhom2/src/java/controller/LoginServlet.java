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
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author DELL
 */
@WebServlet(name="LoginServlet", urlPatterns={"/login"})
public class LoginServlet extends HttpServlet {
   
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
            out.println("<title>Servlet LoginServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath () + "</h1>");
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
        response.sendRedirect("./Account/login.jsp");
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
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        AccountDAO cdb = new AccountDAO();
        Account c1 = cdb.getAccountByUsername(username);
        request.setAttribute("account", c1);

        if (c1 == null) {
            String ms = "Username not exist";
            request.setAttribute("error", ms);
            request.getRequestDispatcher("./Account/login.jsp").forward(request, response);
        } else if (password.equals(c1.getPassword())) {
            if (remember != null) {
                Cookie uidCookie = new Cookie("uid-cookie", String.valueOf(c1.getUid()));
                Cookie passwordCookie = new Cookie("password-cookie", password);
                Cookie roleCookie = new Cookie("role-cookie", String.valueOf(c1.getRole()));
                uidCookie.setMaxAge(24 * 60 * 60);
                passwordCookie.setMaxAge(24 * 60 * 60);
                roleCookie.setMaxAge(24 * 60 * 60);

                response.addCookie(uidCookie);
                response.addCookie(passwordCookie);
                response.addCookie(roleCookie);
            } else {
                Cookie uidCookie = new Cookie("uid-cookie", String.valueOf(c1.getUid()));
                Cookie roleCookie = new Cookie("role-cookie", String.valueOf(c1.getRole()));

                uidCookie.setMaxAge(24 * 60 * 60);
                roleCookie.setMaxAge(24 * 60 * 60);

                response.addCookie(uidCookie);
                response.addCookie(roleCookie);
            }
            switch (c1.getRole()) {
                case 1 ->{
                    request.setAttribute("name", c1.getName());
                    response.sendRedirect("./Account/admin.jsp");
                }
                case 2 ->{
                    request.setAttribute("name", c1.getName());
                    request.getRequestDispatcher("./Account/staff.jsp").forward(request, response);
                }
                default ->
                    response.sendRedirect("productlist");
            }
        } else {
            String ms = "Password was wrong";
            request.setAttribute("error", ms);
            request.getRequestDispatcher("./Account/login.jsp").forward(request, response);
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
