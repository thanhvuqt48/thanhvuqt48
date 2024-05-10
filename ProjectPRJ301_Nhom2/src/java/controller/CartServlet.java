/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.CartDAO;
import dal.ProductDAO;
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
import model.Cart;
import model.Category;
import model.Product;

/**
 *
 * @author DELL
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {

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
            out.println("<title>Servlet CartServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CartServlet at " + request.getContextPath() + "</h1>");
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
                    CartDAO cd = new CartDAO();
                    List<Cart> carts = cd.getCartsByUid(uid);
                    BigDecimal totalMoney = BigDecimal.ZERO;
                    for (Cart c : carts) {
                        totalMoney = totalMoney.add(BigDecimal.valueOf(c.getQuantity()).multiply(c.getProduct().getPrice()));
                    }
                    List<Category> categories = cd.getAllCategory();

                    request.setAttribute("categories", categories);
                    request.setAttribute("totalMoney", totalMoney);
                    request.setAttribute("carts", carts);
                    request.getRequestDispatcher("./Product/cart.jsp").forward(request, response);
                } catch (NumberFormatException e) {

                }
            } else {
                response.sendRedirect("Account/login.jsp");

            }
        } else {
            response.sendRedirect("Account/login.jsp");
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
        String quantity_raw = request.getParameter("quantity");
        String size_raw = request.getParameter("size");
        String pid = request.getParameter("pid");
        Cookie[] cookieses = request.getCookies();
        String uid_raw = "";
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
                    CartDAO cd = new CartDAO();
                    int quantity = Integer.parseInt(quantity_raw);
                    int size = Integer.parseInt(size_raw);
                    Cart c = new Cart(cd.getProductByID(pid), cd.getAccountById(uid), quantity, size);
                    cd.insertCart(c);
                    ProductDAO pd = new ProductDAO();
                    Product p = pd.getProductByID(pid);
                    List<Category> categories = pd.getAllCategory();

                    request.setAttribute("categories", categories);
                    request.setAttribute("product", p);
                    request.getRequestDispatcher("./Product/detail.jsp").forward(request, response);
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
