package org.apache.jsp.account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Users;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Login</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("        <meta name=\"keywords\" content=\"Buy_shop Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, \n");
      out.write("        Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design\" />\n");
      out.write("        <script type=\"application/x-javascript\"> addEventListener(\"load\", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>\n");
      out.write("        <link href=\"../css/bootstrap.css\" rel='stylesheet' type='text/css' />\n");
      out.write("        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\n");
      out.write("        <!-- Custom Theme files -->\n");
      out.write("        <link href=\"../css/style.css\" rel='stylesheet' type='text/css' />\n");
      out.write("        <!--<script src=\"../js/simpleCart.min.js\"> </script>-->\n");
      out.write("        <!-- Custom Theme files -->\n");
      out.write("        <!--webfont-->\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Lato:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>\n");
      out.write("        <script type=\"text/javascript\" src=\"../js/jquery-1.11.1.min.js\"></script>\n");
      out.write("        <!-- start menu -->\n");
      out.write("        <link href=\"../css/megamenu.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\n");
      out.write("        <script type=\"text/javascript\" src=\"../js/megamenu.js\"></script>\n");
      out.write("        <script>$(document).ready(function(){$(\".megamenu\").megamenu();});</script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            Users user = (Users) session.getAttribute("user");
            if(user != null) {
                response.sendRedirect("../index.jsp");
            }
            
            String error = "";
            if(request.getParameter("error") != null) {
                error = request.getParameter("error");
            }
        
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../webmaster/header.jsp", out, false);
      out.write("\n");
      out.write("        <div class=\"single_top\">\n");
      out.write("            <div class=\"container\"> \n");
      out.write("                <div class=\"register flex-col\">\n");
      out.write("                        <div class=\"register-content flex-col\">\n");
      out.write("                            <h4>LOGIN <span style=\"font-size: 16px;\">&</span> START SHOPPING</h4>\n");
      out.write("                            <form action=\"/shop/UsersServlet\" method=\"post\" class=\"form-register flex-col\">\n");
      out.write("                                <input type=\"text\" name=\"email\" class=\"form-input\" placeholder=\"Email Address\"> \n");
      out.write("\n");
      out.write("                                <input type=\"password\" name=\"password\" class=\"form-input\" placeholder=\"Password\"> \n");
      out.write("                                \n");
      out.write("                                ");
 if(error.equals("invalid")) { 
      out.write("\n");
      out.write("                                    <span class=\"error-notify\">Invalid email or password.</span>\n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("                                \n");
      out.write("                                <!--<span class=\"password-tip\"> <a>Forgot your password?</a></span>-->    \n");
      out.write("                                \n");
      out.write("                                <input type=\"hidden\" value=\"login\" name=\"command\">\n");
      out.write("                                <input type=\"submit\" value=\"Login Now\" name=\"submit-register\" class=\"form-input btn-register\">\n");
      out.write("                                \n");
      out.write("                                <span class=\"switch-to-login\">Don't have an account? <a href=\"register.jsp\"> Register Now </a></span> \n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("            </div>\n");
      out.write("        </div>      \n");
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
