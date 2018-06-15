package org.apache.jsp.webmaster;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import model.Category;
import DAO.CategoryDAO;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Header</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 
            CategoryDAO catDAO = new CategoryDAO();
        
      out.write("\n");
      out.write("        <div class=\"header_top\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("<!--                <div class=\"one-fifth column row_1\">\n");
      out.write("                    <span class=\"selection-box\"><select class=\"domains valid\" name=\"domains\">\n");
      out.write("                    <option>English</option>\n");
      out.write("                    <option>French</option>\n");
      out.write("                    <option>German</option>\n");
      out.write("                    </select></span>\n");
      out.write("                </div>-->\n");
      out.write("                <div class=\"cssmenu\">\n");
      out.write("                    <ul>\n");
      out.write("                        <li class=\"active\"><a href=\"login.html\">My Account</a></li> \n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"wrap-box\"></div>\n");
      out.write("        \n");
      out.write("        <div class=\"header_bottom\">\n");
      out.write("\t    <div class=\"container\">\n");
      out.write("                <div class=\"col-xs-8 header-bottom-left\">\n");
      out.write("                    <div class=\"col-xs-3 logo\">\n");
      out.write("                        <h1><a href=\"../index.jsp\"><span>Ann</span>Cosmetics</a></h1>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-xs-5 menu\">\n");
      out.write("                        <ul class=\"megamenu skyblue\">\n");
      out.write("                            <li class=\"showhide\" style=\"display: none;\">\n");
      out.write("                                <span class=\"title\">MENU</span>\n");
      out.write("                                <span class=\"icon1\"></span>\n");
      out.write("                                <span class=\"icon2\"></span>\n");
      out.write("                            </li>\n");
      out.write("                            ");
 for(Category list : catDAO.getListCategory()) { 
      out.write("\n");
      out.write("                                <li class=\"active grid\" style=\"display: inline;\">\n");
      out.write("                                    <a class=\"color-main-hover item-megamenu\" href=\"../category/index.jsp?slug=");
      out.print(list.getSlug());
      out.write('"');
      out.write('>');
      out.print(list.getCatName());
      out.write("</a>\n");
      out.write("                                    ");
 
                                        ArrayList<Category> listChild = catDAO.getChildListCategory(list.getCatId());
                                        if(!listChild.isEmpty()) { 
                                    
      out.write("\n");
      out.write("                                    <div class=\"megapanel\">\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            <div class=\"h_nav\">\n");
      out.write("                                                <ul>\n");
      out.write("                                                    ");
 for(Category list_child : listChild) { 
      out.write("\n");
      out.write("                                                        <li><a href=\"../category/index.jsp?slug=");
      out.print(list_child.getSlug());
      out.write('"');
      out.write('>');
      out.print(list_child.getCatName());
      out.write("</a></li>\n");
      out.write("                                                    ");
 } 
      out.write("\n");
      out.write("                                                </ul>\t\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    ");
 } 
      out.write("\n");
      out.write("                                </li>\n");
      out.write("                            ");
 } 
      out.write("\n");
      out.write("                        </ul> \n");
      out.write("                    </div>\n");
      out.write("\t\t</div>\n");
      out.write("                <div class=\"col-xs-4 header-bottom-right\">\n");
      out.write("                    <div class=\"search flex-row\">\t  \n");
      out.write("                        <input type=\"text\" name=\"s\" class=\"textbox\" value=\"Search\" onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = 'Search';}\">\n");
      out.write("                        <input type=\"submit\" value=\"Subscribe\" id=\"submit\" name=\"submit\">\n");
      out.write("                        <div id=\"response\"> </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"box_1-cart flex-row\">\n");
      out.write("                        <div class=\"box_11\">\n");
      out.write("                            <a href=\"checkout.html\">\n");
      out.write("                                <h4>\n");
      out.write("                                    <p>Cart: <span class=\"simpleCart_total\">$0.00</span> (<span id=\"simpleCart_quantity\" class=\"simpleCart_quantity\">0</span> items)</p>\n");
      out.write("                                    <img src=\"../images/bag.png\" alt=\"\">\n");
      out.write("                                    <div class=\"clearfix\"> </div>\n");
      out.write("                                </h4>\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("<!--                        <p class=\"empty\"><a href=\"javascript:;\" class=\"simpleCart_empty\">Empty Cart</a></p>\n");
      out.write("                        <div class=\"clearfix\"> </div>-->\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"clearfix\"></div>\n");
      out.write("            </div>\n");
      out.write("        </div>    \n");
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
