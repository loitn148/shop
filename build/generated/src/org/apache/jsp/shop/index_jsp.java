package org.apache.jsp.shop;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import model.Product;
import model.Product;
import DAO.ProductDAO;
import DAO.ProductDAO;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Shop</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("        <meta name=\"keywords\" content=\"Buy_shop Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, \n");
      out.write("              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design\" />\n");
      out.write("        <script type=\"application/x-javascript\"> addEventListener(\"load\", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>\n");
      out.write("        <link href=\"../css/bootstrap.css\" rel='stylesheet' type='text/css' />\n");
      out.write("        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\n");
      out.write("        <!-- Custom Theme files -->\n");
      out.write("        <link href=\"../css/style.css\" rel='stylesheet' type='text/css' />\n");
      out.write("        <script src=\"../js/simpleCart.min.js\"></script>\n");
      out.write("        <!-- Custom Theme files -->\n");
      out.write("        <!--webfont-->\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Lato:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>\n");
      out.write("        <script type=\"text/javascript\" src=\"../js/jquery-1.11.1.min.js\"></script>\n");
      out.write("        <!-- start menu -->\n");
      out.write("        <link href=\"../css/megamenu.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\n");
      out.write("        <script type=\"text/javascript\" src=\"../js/megamenu.js\"></script>\n");
      out.write("        <script>$(document).ready(function () {\n");
      out.write("            $(\".megamenu\").megamenu();\n");
      out.write("        });</script>\n");
      out.write("        <script type=\"text/javascript\" src=\"../js/jquery.jscrollpane.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" id=\"sourcecode\">\n");
      out.write("            $(function () {\n");
      out.write("                $('.scroll-pane').jScrollPane();\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("        ");

            ProductDAO prodDAO = new ProductDAO();
            ArrayList<Product> listProd = prodDAO.getListProduct();
            
            NumberFormat nf = NumberFormat.getInstance();
        
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../webmaster/header.jsp", out, false);
      out.write("\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"women_main row\">\n");
      out.write("                    <div class=\"col-md-9\">\n");
      out.write("                        <div class=\"w_content\">\n");
      out.write("                            <div class=\"women\">\n");
      out.write("                                <a href=\"#\"><h4>");
      out.print(listProd.size());
      out.write(" products </h4></a>\n");
      out.write("                                <ul class=\"w_nav\">\n");
      out.write("                                    <li>Sort : </li>\n");
      out.write("                                    <li><a class=\"active\" href=\"#\">popular</a></li> |\n");
      out.write("                                    <li><a href=\"#\">new </a></li> |\n");
      out.write("                                    <li><a href=\"#\">discount</a></li> |\n");
      out.write("                                    <li><a href=\"#\">price: Low High </a></li> \n");
      out.write("                                    <div class=\"clear\"></div>\n");
      out.write("                                </ul>\n");
      out.write("                                <div class=\"clearfix\"></div>\t\n");
      out.write("                            </div>\n");
      out.write("                            <!-- grids_of_4 -->\n");
      out.write("                            <div class=\"row list-product\">\n");
      out.write("                                ");
 for (Product prod : listProd) { 
      out.write("\n");
      out.write("                                \n");
      out.write("                                <div class=\"grid1_of_4 simpleCart_shelfItem\">\n");
      out.write("                                    <div class=\"content_box\">\n");
      out.write("                                        <a href=\"../product/index.jsp?slug=");
      out.print(prod.getProductId());
      out.write("\">\n");
      out.write("                                            <div class=\"view view-fifth\">\n");
      out.write("                                                <img src=\"");
      out.print(prod.getProductImage());
      out.write("\" class=\"img-responsive\" alt=\"\"/>\n");
      out.write("                                            </div>\n");
      out.write("                                        </a>\n");
      out.write("                                    </div>\n");
      out.write("                                    <h5><a class=\"product-name\" href=\"../product/index.jsp?slug=");
      out.print(prod.getProductId());
      out.write('"');
      out.write('>');
      out.print(prod.getProductName());
      out.write("</a></h5>\n");
      out.write("                                    <div class=\"size_1\">\n");
      out.write("                                        ");

                                            if(prod.getProductDiscount() != 0) {
                                                double salePrice = prod.getProductPrice() - prod.getProductPrice()*prod.getProductDiscount()/100;
                                        
      out.write("\n");
      out.write("                                            <span class=\"item_price_original\">");
      out.print(nf.format(prod.getProductPrice()));
      out.write("</span>\n");
      out.write("                                            <span class=\"item_price\">");
      out.print(nf.format(salePrice) + " VND");
      out.write("</span>\n");
      out.write("                                        ");
 } else { 
      out.write("\n");
      out.write("                                            <span class=\"item_price\">");
      out.print(nf.format(prod.getProductPrice()) + " VND");
      out.write("</span>\n");
      out.write("                                        ");
 } 
      out.write("\n");
      out.write("                                        <div class=\"clearfix\"></div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"size_2\">\n");
      out.write("                                        <input type=\"number\" class=\"item_quantity quantity_1\" value=\"1\" min=\"1\"/>\n");
      out.write("                                        <input type=\"button\" class=\"item_add add3\" value=\"\" />\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                \n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("                                <div class=\"clearfix\"></div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-3\">\n");
      out.write("                    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../webmaster/sidebar.jsp", out, false);
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../webmaster/footer.jsp", out, false);
      out.write("\n");
      out.write("    \n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
