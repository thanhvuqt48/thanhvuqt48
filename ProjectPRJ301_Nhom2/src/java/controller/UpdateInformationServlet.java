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
@WebServlet(name = "UpdateInformationServlet", urlPatterns = {"/updateinformation"})
public class UpdateInformationServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
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
            out.println("<title>Servlet UpdateInformationServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateInformationServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        Cookie[] cookieses = request.getCookies();
        String uid_raw = "";
        AccountDAO cdb = new AccountDAO();
        if (cookieses != null) {
            for (int i = 0; i < cookieses.length; i++) {
                Cookie cookie = cookieses[i];
                if (cookie.getName().equals("uid-cookie")) {
                    uid_raw = cookie.getValue();
                    try {
                        int uid = Integer.parseInt(uid_raw);
                        Account c = cdb.getAccountByUid(uid);
                        request.setAttribute("ac", c);
                        request.getRequestDispatcher("./Account/updateinformation.jsp").forward(request, response);
                    } catch (NumberFormatException e) {
                    }
                }
            }
        }
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
        String username = request.getParameter("username");
        String fullname = request.getParameter("fullname");
        String phonenumber = request.getParameter("phonenumber");
        String address = request.getParameter("address");

        AccountDAO cdb = new AccountDAO();
        Account c = cdb.getAccountByUsername(username);
        if (phonenumber.length() != 10) {
            String ms = "Phone number is wrong";
            request.setAttribute("error", ms);
            request.getRequestDispatcher("./Account/updateinformation.jsp").forward(request, response);
        } else {
            Account c1 = new Account(c.getUid(), username, phonenumber, c.getPassword(), address, fullname, c.getRole());
            cdb.updateInformation(c1);
            response.sendRedirect("productlist");
        }
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
