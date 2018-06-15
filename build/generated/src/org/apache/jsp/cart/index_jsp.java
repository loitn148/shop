package org.apache.jsp.cart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Cart</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("        <meta name=\"keywords\" content=\"Buy_shop Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, \n");
      out.write("              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design\" />\n");
      out.write("        <script type=\"application/x-javascript\"> addEventListener(\"load\", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>\n");
      out.write("        <link href=\"../css/bootstrap.css\" rel='stylesheet' type='text/css' />\n");
      out.write("        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\n");
      out.write("        <!-- Custom Theme files -->\n");
      out.write("        <link href=\"../css/style.css\" rel='stylesheet' type='text/css' />\n");
      out.write("        <!--<script src=\"../js/simpleCart.min.js\"></script>-->\n");
      out.write("        <!-- Custom Theme files -->\n");
      out.write("        <!--webfont-->\n");
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
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"check\">\t \n");
      out.write("                ");
 if (cart.getCartItem().size() == 0) { 
      out.write("\n");
      out.write("                    <h1 style=\"font-size: 1.5em; margin-bottom: 2em;\">Shopping Cart (0)</h1>\n");
      out.write("                    <div class=\"content flex-col\">\n");
      out.write("                        <img src=\"../images/empty-cart.png\">\n");
      out.write("                        <a href=\"/shop/shop/index.jsp\" class=\"continue-shopping\">\n");
      out.write("                            Go Shop Now\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                ");
 } else { 
      out.write("\n");
      out.write("                <script>\n");
      out.write("                    $(document).ready(function (c) {\n");
      out.write("                        $('.close1').on('click', function (c) {\n");
      out.write("                            $('.cart-header').fadeOut('slow', function (c) {\n");
      out.write("                                $('.cart-header').remove();\n");
      out.write("                            });\n");
      out.write("                        });\n");
      out.write("\n");
      out.write("                        $('.close2').on('click', function (c) {\n");
      out.write("                            $('.cart-header2').fadeOut('slow', function (c) {\n");
      out.write("                                $('.cart-header2').remove();\n");
      out.write("                            });\n");
      out.write("                        });\n");
      out.write("                    });\n");
      out.write("                </script>\n");
      out.write("                <div class=\"col-md-9 cart-items\">\n");
      out.write("                    <h1>Shopping Cart (2)</h1>\n");
      out.write("                    <div class=\"cart-header\">\n");
      out.write("                        <div class=\"close1\"> </div>\n");
      out.write("                        <div class=\"cart-sec simpleCart_shelfItem\">\n");
      out.write("                            <div class=\"cart-item cyc\">\n");
      out.write("                                <img src=\"../images/pic1.jpg\" class=\"img-responsive\" alt=\"\"/>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"cart-item-info\">\n");
      out.write("                                <h3><a href=\"#\">Mountain Hopper(XS R034)</a><span>Model No: 3578</span></h3>\n");
      out.write("                                <ul class=\"qty\">\n");
      out.write("                                    <li><p>Size : 5</p></li>\n");
      out.write("                                    <li><p>Qty : 1</p></li>\n");
      out.write("                                </ul>\n");
      out.write("                                <div class=\"delivery\">\n");
      out.write("                                    <p>Service Charges : Rs.100.00</p>\n");
      out.write("                                    <span>Delivered in 2-3 bussiness days</span>\n");
      out.write("                                    <div class=\"clearfix\"></div>\n");
      out.write("                                </div>\t\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"clearfix\"></div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"cart-header2\">\n");
      out.write("                        <div class=\"close2\"> </div>\n");
      out.write("                        <div class=\"cart-sec simpleCart_shelfItem\">\n");
      out.write("                            <div class=\"cart-item cyc\">\n");
      out.write("                                <img src=\"../images/pic2.jpg\" class=\"img-responsive\" alt=\"\"/>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"cart-item-info\">\n");
      out.write("                                <h3><a href=\"#\">Mountain Hopper(XS R034)</a><span>Model No: 3578</span></h3>\n");
      out.write("                                <ul class=\"qty\">\n");
      out.write("                                    <li><p>Size : 5</p></li>\n");
      out.write("                                    <li><p>Qty : 1</p></li>\n");
      out.write("                                </ul>\n");
      out.write("                                <div class=\"delivery\">\n");
      out.write("                                    <p>Service Charges : Rs.100.00</p>\n");
      out.write("                                    <span>Delivered in 2-3 bussiness days</span>\n");
      out.write("                                    <div class=\"clearfix\"></div>\n");
      out.write("                                </div>\t\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"clearfix\"></div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\t\t\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-3 cart-total\">\n");
      out.write("                    <a class=\"continue\" href=\"#\">Continue to basket</a>\n");
      out.write("                    <div class=\"price-details\">\n");
      out.write("                        <h3>Price Details</h3>\n");
      out.write("                        <span>Total</span>\n");
      out.write("                        <span class=\"total1\">6200.00</span>\n");
      out.write("                        <span>Discount</span>\n");
      out.write("                        <span class=\"total1\">---</span>\n");
      out.write("                        <span>Delivery Charges</span>\n");
      out.write("                        <span class=\"total1\">150.00</span>\n");
      out.write("                        <div class=\"clearfix\"></div>\t\t\t\t \n");
      out.write("                    </div>\t\n");
      out.write("                    <ul class=\"total_price\">\n");
      out.write("                        <li class=\"last_price\"> <h4>TOTAL</h4></li>\t\n");
      out.write("                        <li class=\"last_price\"><span>6350.00</span></li>\n");
      out.write("                        <div class=\"clearfix\"> </div>\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"clearfix\"></div>\n");
      out.write("                    <a class=\"order\" href=\"#\">Place Order</a>\n");
      out.write("                    <div class=\"total-item\">\n");
      out.write("                        <h3>OPTIONS</h3>\n");
      out.write("                        <h4>COUPONS</h4>\n");
      out.write("                        <a class=\"cpns\" href=\"#\">Apply Coupons</a>\n");
      out.write("                        <p><a href=\"#\">Log In</a> to use accounts - linked coupons</p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
