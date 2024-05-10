<%-- 
    Document   : list_product
    Created on : Feb 1, 2024, 8:17:43 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Product, java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fruit Shop</title>
         <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <%
                    List<Product> list = (List<Product>) request.getAttribute("data");
                    for (Product f : list){
                    out.write("<div class='col-md-4' align='center'>");
                      out.write("<div class='card' style='width: 18rem;'>");
                          out.write("<img src='" + f.getProductImage() + "' class='card-img-top' alt='image'> ");
                         out.write("<div class='card-body'>");
                            out.write("<h5 class='card-title'>" + f.getProductName() + "<h5/>");
                            out.write("<p class='card-text'>" + f.getDescription() + "<p/>");
                         out.write("</div>");
                      out.write("</div>");
                    out.write("</div>");
                    }
                %>
            </div>
        </div>
    </body>
</html>
