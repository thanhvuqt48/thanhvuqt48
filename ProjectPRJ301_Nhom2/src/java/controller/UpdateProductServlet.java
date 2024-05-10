/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import model.Product;

/**
 *
 * @author DELL
 */
@WebServlet(name="UpdateProductServlet", urlPatterns={"/updateproduct"})
public class UpdateProductServlet extends HttpServlet {
   
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
            out.println("<title>Servlet UpdateProductServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateProductServlet at " + request.getContextPath () + "</h1>");
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
        String id = request.getParameter("id");
        ProductDAO cdb = new ProductDAO();
        Product c = cdb.getProductByID(id);
        request.setAttribute("product", c);
        request.getRequestDispatcher("./ProductManager/updateproduct.jsp").forward(request, response);
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
        String id = request.getParameter("productid");
        String name = request.getParameter("productname");
        String desc = request.getParameter("describe");
        String price_raw = request.getParameter("price");
        String category_raw = request.getParameter("category");
        String img = request.getParameter("image");
        BigDecimal price;
        int category;
        switch (category_raw) {
            case "Nike Air Force 1":
                category = 1;
                break;
            case "Nike Air Jordan 1":
                category = 2;
                break;
            case "Nike Air Max":
                category = 3;
                break;
            case "Nike Pegasus":
                category = 4;
                break;
            default:
                throw new AssertionError();
        }
        try {
            price = new BigDecimal(price_raw);
            ProductDAO cdb = new ProductDAO();
            Product c1 = new Product(id, name, price, desc, img, cdb.getCategoryById(category));
            cdb.updateProduct(c1);
            response.sendRedirect("productlistmanager");
        } catch (NumberFormatException e) {
            String ms1 = "Price is a number";
            request.setAttribute("error", ms1);
            request.getRequestDispatcher("./ProductManager/updateproduct.jsp").forward(request, response);
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
