package org.apache.jsp.product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Cart;
import java.text.NumberFormat;
import java.util.ArrayList;
import DAO.ProductGalleryDAO;
import model.ProductGallery;
import model.Product;
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Product</title>\n");
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
      out.write("        <link rel=\"stylesheet\" href=\"../css/etalage.css\">\n");
      out.write("        <script src=\"../js/jquery.etalage.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            jQuery(document).ready(function($){\n");
      out.write("                $('#etalage').etalage({\n");
      out.write("                    thumb_image_width: 300,\n");
      out.write("                    thumb_image_height: 400,\n");
      out.write("                    source_image_width: 900,\n");
      out.write("                    source_image_height: 1200,\n");
      out.write("                    show_hint: true,\n");
      out.write("                    click_callback: function(image_anchor, instance_id){\n");
      out.write("                        alert('Callback example:\\nYou clicked on an image with the anchor: \"'+image_anchor+'\"\\n(in Etalage instance: \"'+instance_id+'\")');\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("        <!--initiate accordion-->\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(function() {\n");
      out.write("                var menu_ul = $('.menu_drop > li > ul'),\n");
      out.write("                    menu_a  = $('.menu_drop > li > a');\n");
      out.write("\n");
      out.write("                menu_ul.hide();\n");
      out.write("\n");
      out.write("                menu_a.click(function(e) {\n");
      out.write("                    e.preventDefault();\n");
      out.write("                    if(!$(this).hasClass('active')) {\n");
      out.write("                        menu_a.removeClass('active');\n");
      out.write("                        menu_ul.filter(':visible').slideUp('normal');\n");
      out.write("                        $(this).addClass('active').next().stop(true,true).slideDown('normal');\n");
      out.write("                    } else {\n");
      out.write("                        $(this).removeClass('active');\n");
      out.write("                        $(this).next().stop(true,true).slideUp('normal');\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String prod_slug = "";
            if(request.getParameter("slug") != null){
                prod_slug = request.getParameter("slug");
            }
            ProductDAO prodDAO = new ProductDAO();
            Product product = prodDAO.getProduct(prod_slug);
            ArrayList<Product> listRelated = prodDAO.getListProductByCategory(product.getCategoryId());
            
            ProductGalleryDAO galleryDAO = new ProductGalleryDAO();
            ArrayList<ProductGallery> listGallery = galleryDAO.getListGallery(prod_slug);
            
            NumberFormat nf = NumberFormat.getInstance();
            
            Cart cart = (Cart) session.getAttribute("cart");
            if(cart == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
        
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../webmaster/header.jsp", out, false);
      out.write("\n");
      out.write("        <div class=\"single_top\">\n");
      out.write("            <div class=\"container\"> \n");
      out.write("                <div class=\"single_grid\">\n");
      out.write("                    <div class=\"grid images_3_of_2\">\n");
      out.write("                        <ul id=\"etalage\">\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"\">\n");
      out.write("                                    <img class=\"etalage_thumb_image\" src=\"");
      out.print(product.getProductImage());
      out.write("\" class=\"img-responsive\" />\n");
      out.write("                                    <img class=\"etalage_source_image\" src=\"");
      out.print(product.getProductImage());
      out.write("\" class=\"img-responsive\" title=\"\" />\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                            ");
 for(ProductGallery gallery : listGallery) { 
      out.write("\n");
      out.write("                                <li>\n");
      out.write("                                    <img class=\"etalage_thumb_image\" src=\"");
      out.print(gallery.getImageGallery());
      out.write("\" class=\"img-responsive\" />\n");
      out.write("                                    <img class=\"etalage_source_image\" src=\"");
      out.print(gallery.getImageGallery());
      out.write("\" class=\"img-responsive\" title=\"\" />\n");
      out.write("                                </li>\n");
      out.write("                            ");
 } 
      out.write("\n");
      out.write("                        </ul>\n");
      out.write("                        <div class=\"clearfix\"></div>\t\t\n");
      out.write("                    </div> \n");
      out.write("                    <div class=\"desc1 span_3_of_2\">\n");
      out.write("                        <h1>");
      out.print(product.getProductName());
      out.write("</h1>\n");
      out.write("                        <div>");
      out.print(product.getProductDescription());
      out.write("</div>\n");
      out.write("                        <div class=\"simpleCart_shelfItem\" style=\"border-top: 1px solid #4c4c4c; margin-top: 20px;\">\n");
      out.write("                            <div class=\"price_single\">\n");
      out.write("                                <h3>\n");
      out.write("                                    ");

                                        if(product.getProductDiscount() != 0) {
                                            double salePrice = product.getProductPrice() - product.getProductPrice()*product.getProductDiscount()/100;
                                    
      out.write("\n");
      out.write("                                        <span class=\"item_price_original\" style=\"margin-right: 10px;\">");
      out.print(nf.format(product.getProductPrice()));
      out.write("</span>\n");
      out.write("                                        <span class=\"amount item_price\">");
      out.print(nf.format(salePrice) + " VND");
      out.write("</span>\n");
      out.write("                                    ");
 } else { 
      out.write("\n");
      out.write("                                        <span class=\"amount item_price\">");
      out.print(nf.format(product.getProductPrice()) + " VND");
      out.write("</span>\n");
      out.write("                                    ");
 } 
      out.write("\n");
      out.write("                                </h3>\n");
      out.write("                            </div>\n");
      out.write("                            <!--<div class=\"single_but\"><a href=\"\" class=\"item_add btn_3\" value=\"\"></a></div>-->\n");
      out.write("                            <div class=\"size_2-right\">\n");
      out.write("                                <a href=\"/shop/CartServlet?command=plus&productId=");
      out.print(product.getProductId());
      out.write("\" class=\"item_add item_add1 btn_5\" value=\"\">\n");
      out.write("                                    <img src=\"../images/cart-3.png\"  style=\"margin-right: 5px;\"/>\n");
      out.write("                                    Add to Cart\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"clearfix\"></div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"single_social_top\">   \n");
      out.write("                    <ul class=\"single_social\">\n");
      out.write("                        <li><a href=\"#\"> <i class=\"s_fb\"> </i> <div class=\"social_desc\">Share<br> on facebook</div><div class=\"clearfix\"> </div></a></li>\n");
      out.write("                        <li><a href=\"#\"> <i class=\"s_twt\"> </i> <div class=\"social_desc\">Tweet<br> this product</div><div class=\"clearfix\"> </div></a></li>\n");
      out.write("                        <li><a href=\"#\"> <i class=\"s_google\"> </i><div class=\"social_desc\">Google+<br> this product</div><div class=\"clearfix\"> </div></a></li>\n");
      out.write("                        <li class=\"last\"><a href=\"#\"> <i class=\"s_email\"> </i><div class=\"social_desc\">Email<br> a Friend</div><div class=\"clearfix\"> </div></a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                <ul class=\"menu_drop\">\n");
      out.write("                    <li class=\"item1\"><a href=\"#\"><img src=\"../images/product_arrow.png\">Description</a>\n");
      out.write("                        <ul>\n");
      out.write("                            <li class=\"subitem1\"><a href=\"#\">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor </a></li>\n");
      out.write("                            <li class=\"subitem2\"><a href=\"#\"> Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore</a></li>\n");
      out.write("                            <li class=\"subitem3\"><a href=\"#\">Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes </a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <h3 class=\"m_2\">Related Products</h3>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"box_3\">\n");
      out.write("                    ");
 int limit = 0; 
      out.write("\n");
      out.write("                    ");
 for(Product pRelated : listRelated) { 
      out.write("\n");
      out.write("                        ");
 if(limit < 4) { 
      out.write("\n");
      out.write("                            <div class=\"grid1_of_4 simpleCart_shelfItem\">\n");
      out.write("                                <div class=\"content_box\">\n");
      out.write("                                    <a href=\"../product/index.jsp?slug=");
      out.print(pRelated.getProductSlug());
      out.write("\">\n");
      out.write("                                        <div class=\"view view-fifth\">\n");
      out.write("                                            <img src=\"");
      out.print(pRelated.getProductImage());
      out.write("\" class=\"img-responsive\" alt=\"\"/>\n");
      out.write("                                        </div>\n");
      out.write("                                    </a>\n");
      out.write("                                </div>\n");
      out.write("                                <h5><a class=\"product-name\" href=\"../product/index.jsp?slug=");
      out.print(pRelated.getProductSlug());
      out.write('"');
      out.write('>');
      out.print(pRelated.getProductName());
      out.write("</a></h5>\n");
      out.write("                                <div class=\"size_1\">\n");
      out.write("                                    ");

                                        if(pRelated.getProductDiscount() != 0) {
                                            double salePrice = pRelated.getProductPrice() - pRelated.getProductPrice()*pRelated.getProductDiscount()/100;
                                    
      out.write("\n");
      out.write("                                        <span class=\"item_price_original\">");
      out.print(nf.format(pRelated.getProductPrice()));
      out.write("</span>\n");
      out.write("                                        <span class=\"item_price\">");
      out.print(nf.format(salePrice) + " VND");
      out.write("</span>\n");
      out.write("                                    ");
 } else { 
      out.write("\n");
      out.write("                                        <span class=\"item_price\">");
      out.print(nf.format(pRelated.getProductPrice()) + " VND");
      out.write("</span>\n");
      out.write("                                    ");
 } 
      out.write("\n");
      out.write("                                    <div class=\"clearfix\"></div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"size_2\">\n");
      out.write("                                    <input type=\"number\" class=\"item_quantity quantity_1\" value=\"1\" min=\"1\"/>\n");
      out.write("                                    <input type=\"button\" class=\"item_add add3\" value=\"\" />\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        ");
 } 
      out.write("\n");
      out.write("                        ");
 limit++; 
      out.write("\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("                    <div class=\"clearfix\"> </div>\n");
      out.write("                </div>\n");
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
