package org.apache.jsp.checkout;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Map;
import model.Product;
import model.Item;
import model.Cart;

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Checkout</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("        <meta name=\"keywords\" content=\"Buy_shop Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, \n");
      out.write("              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design\" />\n");
      out.write("        <script type=\"application/x-javascript\"> addEventListener(\"load\", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>\n");
      out.write("        <link href=\"../css/bootstrap.css\" rel='stylesheet' type='text/css' />\n");
      out.write("        <link href=\"../css/style.css\" rel='stylesheet' type='text/css' />\n");
      out.write("        <!--<script src=\"../js/simpleCart.min.js\"></script>-->\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Lato:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>\n");
      out.write("        <script type=\"text/javascript\" src=\"../js/jquery-1.11.1.min.js\"></script>\n");
      out.write("        <!-- start menu -->\n");
      out.write("        <link href=\"../css/megamenu.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\n");
      out.write("        <script type=\"text/javascript\" src=\"../js/megamenu.js\"></script>\n");
      out.write("        <script>$(document).ready(function () {\n");
      out.write("                $(\".megamenu\").megamenu();\n");
      out.write("            });</script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
        
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../webmaster/header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"container\"> \n");
      out.write("                <div class=\"check row\">\n");
      out.write("                    <h1>Checkout</h1>\n");
      out.write("                    <form>\n");
      out.write("                        <div class=\"col-md-8\">\n");
      out.write("                            <label for=\"owner\">*Owner</label>\n");
      out.write("                            <input type=\"text\" name=\"owner\" value=\"\" class=\"order-input\">\n");
      out.write("                            \n");
      out.write("                            <label for=\"phone\">*Phone Number</label>\n");
      out.write("                            <input type=\"text\" name=\"phone\" value=\"\" class=\"order-input\">\n");
      out.write("                            \n");
      out.write("                            <label for=\"address\">*Address</label>\n");
      out.write("                            <input type=\"text\" name=\"address\" value=\"\" class=\"order-input\">\n");
      out.write("                            \n");
      out.write("                            <label for=\"payment\">*Payment</label>\n");
      out.write("                            <select name=\"payment\">\n");
      out.write("                                <option value=\"\">-- None --</option>\n");
      out.write("                                <option value=\"\">Cash on delivery</option>\n");
      out.write("                                <option value=\"\">Direct bank transfer</option>\n");
      out.write("                            </select>\n");
      out.write("                            <label for=\"note\">Note</label>\n");
      out.write("                            <textarea name=\"note\" class=\"order-input\"></textarea>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"col-md-4\">\n");
      out.write("                            <div class=\"order-summary\">\n");
      out.write("                                <div class=\"order-header flex-row\">\n");
      out.write("                                    <h4 style=\"width: 60%; text-align: left;\">Order Summary</h4>\n");
      out.write("                                    <a href=\"/shop/cart/index.jsp\" style=\"width: 40%; text-align: right;\"> Edit Cart </a>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"order-details\">\n");
      out.write("                                    <h5 style=\"font-weight: 600\">");
      out.print(cart.countItem()+" item(s)");
      out.write("</h5>\n");
      out.write("                                    <table >\n");
      out.write("                                        ");
 for (Map.Entry<Long, Item> list : cart.getCartItem().entrySet()) { 
      out.write("\n");
      out.write("                                            ");
 Product product = list.getValue().getProduct();
      out.write("\n");
      out.write("\n");
      out.write("                                        <tr style=\"padding: 10px 0\">\n");
      out.write("                                            <td width=\"30%\" style=\"text-align: center\">\n");
      out.write("                                                <img src=\"");
      out.print(product.getProductImage());
      out.write("\" class=\"img-responsive\" alt=\"\"/>\n");
      out.write("                                            </td>\n");
      out.write("                                            <td style=\"padding-right: 10px;\">\n");
      out.write("                                                <h4>");
      out.print(list.getValue().getQuantity() + " x " + product.getProductName());
      out.write("</h4>\n");
      out.write("                                            </td>\n");
      out.write("                                            <td>\n");
      out.write("                                                <h4>");
      out.print( "$"+ product.getProductPriceSale() * list.getValue().getQuantity());
      out.write("</h4>\n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        ");
 }
      out.write("\t\n");
      out.write("                                    </table>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"order-total flex-row\">\n");
      out.write("                                    <h4 style=\"width: 40%; text-align: left;\">Total (USD)</h4>\n");
      out.write("                                    <h2 style=\"width: 60%; text-align: right; font-weight: 600\">");
      out.print("$"+cart.totalCart());
      out.write("</h2>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../webmaster/footer.jsp", out, false);
      out.write("\n");
      out.write("    </body>\n");
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
