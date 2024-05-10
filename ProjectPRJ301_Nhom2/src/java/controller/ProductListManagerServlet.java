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
import java.util.List;
import model.Category;
import model.Product;

/**
 *
 * @author DELL
 */
@WebServlet(name="ProductListManagerServlet", urlPatterns={"/productlistmanager"})
public class ProductListManagerServlet extends HttpServlet {
   
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
            out.println("<title>Servlet ProductListManagerServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductListManagerServlet at " + request.getContextPath () + "</h1>");
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
        ProductDAO bdo = new ProductDAO();
        List<Category> categories = bdo.getAllCategory();
        // Lấy giá trị của cid từ request

        // Khởi tạo giá trị mặc định cho cid và page
        int page, numberProduct = 12; // Số phần tử trên mỗi trang
        List<Product> list;
        int size;
        // Nếu cid khác 0, lấy danh sách sản phẩm theo cid
        list = bdo.getProductByCid(0);
        size = list.size();

        int numberPage = (size % numberProduct == 0) ? (size / numberProduct) : (size / numberProduct + 1);
        request.setAttribute("numberPage", numberPage);

        // Lấy giá trị của trang từ request
        String xpage = request.getParameter("page");
        if (xpage == null || xpage.isEmpty()) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }

        // Tính vị trí bắt đầu và kết thúc của danh sách sản phẩm trên trang hiện tại
        int start = (page - 1) * numberProduct;
        int end = Math.min(page * numberProduct, size);

        // Lấy danh sách sản phẩm cho trang hiện tại
        list = bdo.getListByPage(list, start, end);

        // Đặt các thuộc tính vào request để chuyển đến JSP
        request.setAttribute("data", list);
        request.setAttribute("page", page);
        request.setAttribute("categories", categories);

        request.getRequestDispatcher("./ProductManager/productlistmanager.jsp").forward(request, response);
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
