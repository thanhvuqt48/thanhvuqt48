/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.CartDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;
import model.Account;
import model.Cart;
import model.Category;

/**
 *
 * @author DELL
 */
@WebServlet(name = "OrderProductServlet", urlPatterns = {"/orderproduct"})
public class OrderProductServlet extends HttpServlet {

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
            out.println("<title>Servlet OrderServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderServlet at " + request.getContextPath() + "</h1>");
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
         request.getRequestDispatcher("./Product/order.jsp").forward(request, response);
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

        String uid_raw = "";
        String type = request.getParameter("type");
        String pid = request.getParameter("pid");
        CartDAO cd = new CartDAO();
        String quantity_raw = request.getParameter("quantity");
        String size_raw = request.getParameter("size");

        Cookie[] cookieses = request.getCookies();
        int uid;
        if (cookieses != null) {
            for (Cookie cookie : cookieses) {
                if (cookie.getName().equals("uid-cookie")) {
                    uid_raw = cookie.getValue();
                }
            }
            if (!"".equals(uid_raw)) {
                try {
                    uid = Integer.parseInt(uid_raw);
                    Account account = cd.getAccountById(uid);
                    BigDecimal totalMoney = BigDecimal.ZERO;
                    if (type != null) {

                        int quantity = Integer.parseInt(quantity_raw);
                        int size = Integer.parseInt(size_raw);
                        Cart c = new Cart(cd.getProductByID(pid), cd.getAccountById(uid), quantity, size);
                        cd.insertCart(c);
                        List<Cart> carts = cd.getCartsByUidAndPid(uid, pid);
                        totalMoney = totalMoney.add(BigDecimal.valueOf(c.getQuantity()).multiply(c.getProduct().getPrice()));
                        List<Category> categories = cd.getAllCategory();

                        request.setAttribute("categories", categories);
                        request.setAttribute("totalMoney", totalMoney);
                        request.setAttribute("carts", carts);
                    } else {
                        List<Cart> carts = cd.getCartsByUid(uid);
                        List<Category> categories = cd.getAllCategory();

                        for (Cart c : carts) {
                            totalMoney = totalMoney.add(BigDecimal.valueOf(c.getQuantity()).multiply(c.getProduct().getPrice()));
                        }
                        request.setAttribute("categories", categories);
                        request.setAttribute("totalMoney", totalMoney);
                        request.setAttribute("carts", carts);

                    }
                    request.setAttribute("account", account);
                    request.getRequestDispatcher("./Product/order.jsp").forward(request, response);
                } catch (NumberFormatException e) {

                }
            } else {
                response.sendRedirect("Account/login.jsp");
            }
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
