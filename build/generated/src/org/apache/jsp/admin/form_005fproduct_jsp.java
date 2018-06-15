package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.DecimalFormat;
import DAO.ProductDAO;
import model.Product;
import java.util.ArrayList;
import model.Category;
import DAO.CategoryDAO;

public final class form_005fproduct_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_set_var_value_nobody.release();
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Insert Product</title>\n");
      out.write("        ");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${root}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/mos-style.css\" rel='stylesheet' type='text/css' />\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${root}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/jquery-1.11.1.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            CategoryDAO catDAO = new CategoryDAO();
            ArrayList<Category> listCategory = catDAO.getAllListCategory();
            
            ProductDAO prodDAO = new ProductDAO();
            
            String prod_id = request.getParameter("product") != null ? request.getParameter("product") : "";
            
            Product product = prod_id.equals("") ? new Product() : prodDAO.getProduct(Long.parseLong(prod_id));
            
            String error = request.getParameter("error") != null ? request.getParameter("error") : "";
            
            DecimalFormat df = new DecimalFormat("###");
        
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("            <div id=\"wrapper\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu.jsp", out, false);
      out.write("\n");
      out.write("                <div id=\"rightContent\">\n");
      out.write("                    <h3>Add Category</h3>\n");
      out.write("                    <form method=\"post\" action=\"UploadIamgesServlet\" enctype=\"multipart/form-data\">\n");
      out.write("                        Select file to upload:\n");
      out.write("                        <input type=\"file\" name=\"uploadFile\" />\n");
      out.write("                        <br/><br/>\n");
      out.write("                        <input type=\"submit\" value=\"Upload\" />\n");
      out.write("                    </form>\n");
      out.write("                    <form action=\"/shop/ManageProductServlet\" method=\"post\">\n");
      out.write("                        <table width=\"95%\">\n");
      out.write("                            <tr><td><b>Image</b></td><td>\n");
      out.write("                                    <input type=\"file\" name=\"prodImage\" accept=\"image/*\">\n");
      out.write("                                </td></tr>\n");
      out.write("                            <tr><td><b>Product Name</b></td><td>\n");
      out.write("                                    <input type=\"text\" class=\"panjang\" name=\"prodName\" value=\"");
      out.print( product.getProductName() != null ? product.getProductName() : "");
      out.write("\">\n");
      out.write("                                </td></tr>\n");
      out.write("                            <tr><td><b>Slug</b></td><td>\n");
      out.write("                                    <input type=\"text\" class=\"panjang\" name=\"prodSlug\" value=\"");
      out.print(product.getProductSlug() != null ? product.getProductSlug() : "");
      out.write("\">\n");
      out.write("                                </td></tr>\n");
      out.write("                            <tr><td><b>Price (VND)</b></td><td>\n");
      out.write("                                    <input type=\"number\" class=\"panjang\" name=\"prodPrice\" value=\"");
      out.print(product.getProductPrice() != 0 ? df.format(product.getProductPrice()) : "");
      out.write("\">\n");
      out.write("                                </td></tr>\n");
      out.write("                            <tr><td><b>Discount (%)</b></td><td>\n");
      out.write("                                    <input type=\"number\" class=\"panjang\" name=\"prodDiscount\" value=\"");
      out.print(product.getProductDiscount() != 0 ? df.format(product.getProductDiscount()) : "");
      out.write("\">\n");
      out.write("                                </td></tr>\n");
      out.write("                            <tr><td><b>Description</b></td><td>\n");
      out.write("                                    <textarea name=\"prodDescription\">");
      out.print(product.getProductDescription() != null ? product.getProductDescription() : "");
      out.write("</textarea>\n");
      out.write("                                </td></tr>\n");
      out.write("                            <tr><td><b>Category</b></td><td>\n");
      out.write("                                    <select name=\"catId\">\n");
      out.write("                                        <option value=\"\">-- None --</option>\n");
      out.write("                                        ");
 for(Category cat : listCategory) { 
      out.write("\n");
      out.write("                                            <option value=\"");
      out.print(cat.getCatId());
      out.write('"');
      out.write(' ');
      out.print( cat.getCatId() == product.getCategoryId() ? "selected" : null );
      out.write('>');
      out.print(cat.getCatName());
      out.write("</option>\n");
      out.write("                                        ");
 } 
      out.write("\n");
      out.write("                                    </select>\n");
      out.write("                                </td></tr>\n");
      out.write("                            <tr><td></td><td>\n");
      out.write("                                ");
      out.print(error);
      out.write("\n");
      out.write("                                </td></tr>\n");
      out.write("                            <tr><td></td><td>\n");
      out.write("                                    ");
 if(prod_id.length() == 0) { 
      out.write("\n");
      out.write("                                        <input type=\"hidden\" name=\"command\" value=\"insert\">\n");
      out.write("                                    ");
 } else { 
      out.write("\n");
      out.write("                                        <input type=\"hidden\" name=\"command\" value=\"update\">\n");
      out.write("                                        <input type=\"hidden\" name=\"product_id\" value=\"");
      out.print(prod_id);
      out.write("\">\n");
      out.write("                                    ");
 } 
      out.write("\n");
      out.write("                                    \n");
      out.write("                                    <input type=\"submit\" class=\"button\" value=\"Submit\">\n");
      out.write("                                    <input type=\"reset\" class=\"button\" value=\"Reset\">\n");
      out.write("                                </td></tr>\n");
      out.write("                        </table>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"clear\"></div>\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("        </div>\n");
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

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("root");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }
}
