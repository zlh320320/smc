/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.30
 * Generated at: 2018-01-19 11:22:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.modules.content;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class editSite_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

private static org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;

static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fns:getSiteById", com.zlh.web.utils.ContentUtils.class, "getSiteById", new Class[] {int.class});
}

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/tlds/fns.tld", Long.valueOf(1516279300851L));
    _jspx_dependants.put("/WEB-INF/modules/sys/common.jsp", Long.valueOf(1516279299605L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("    <title>网站设置</title>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("    <meta name=\"keywords\" content=\"网站设置\" />\r\n");
      out.write("    <meta name=\"description\" content=\"网站设置。\" />\r\n");
      out.write("    <link type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/css/index.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <link type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/front/css/topic.css\" rel=\"stylesheet\" />\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body id=\"index\">\r\n");
      out.write("    <!-- top -->\r\n");
      out.write("    <!-- content -->\r\n");
      out.write("    <div class=\"w-content m-center\">\r\n");
      out.write("       <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/content/saveSite\" method=\"post\" id=\"inputForm\">\r\n");
      out.write("        <input type=\"hidden\" name=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${site.id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("         <div class=\"content\">\r\n");
      out.write("             <div class=\"control\">\r\n");
      out.write("               <label>网站标题:</label>\r\n");
      out.write("               <span class=\"inp\"><input class=\"width300\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${site.siteName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" name=\"siteName\"/></span>\r\n");
      out.write("             </div>\r\n");
      out.write("             <div class=\"control\">\r\n");
      out.write("               <label>网站关键词:</label>\r\n");
      out.write("               <span class=\"inp\"><input class=\"width300\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${site.keywords }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" name=\"keywords\"/></span>\r\n");
      out.write("             </div>\r\n");
      out.write("             <div class=\"control\">\r\n");
      out.write("               <label>网站描述:</label>\r\n");
      out.write("               <span class=\"inp\"><input class=\"width300\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${site.siteDesc }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" name=\"siteDesc\"/></span>\r\n");
      out.write("             </div>\r\n");
      out.write("             \r\n");
      out.write("             <div class=\"control\">\r\n");
      out.write("               <label>logo:</label>\r\n");
      out.write("               <span class=\"inp\">\r\n");
      out.write("               <input type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${site.logo }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" name=\"logo\"/>\r\n");
      out.write("                <input type=\"file\" name=\"files\" id=\"file\">\r\n");
      out.write("               <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${site.logo }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" style=\"width:100px;\"/>\r\n");
      out.write("               </span>\r\n");
      out.write("             </div>\r\n");
      out.write("            \r\n");
      out.write("             <div class=\"operation\">\r\n");
      out.write("                 <input type=\"button\" id=\"saveBtn\" value=\"保存\"/>\r\n");
      out.write("             </div>\r\n");
      out.write("         </div>\r\n");
      out.write("         </form>\r\n");
      out.write("    </div>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/js/jquery-1.8.2.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/js/index.js\"></script>\r\n");
      out.write("     <script type=\"text/javascript\" charset=\"utf-8\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/ueditor/ueditor.config.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" charset=\"utf-8\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/ueditor/ueditor.all.min.js\"> </script>\r\n");
      out.write("    <script type=\"text/javascript\" charset=\"utf-8\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/ueditor/lang/zh-cn/zh-cn.js\"></script>\r\n");
      out.write("     <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/js/ajaxfileupload.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("    \r\n");
      out.write("\t\t$(\"#saveBtn\").click(function(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t    $.ajax({  \r\n");
      out.write("                    type : \"POST\",  //提交方式  \r\n");
      out.write("                    url : $(\"#inputForm\").attr(\"action\"),//路径  \r\n");
      out.write("                    data :  $(\"#inputForm\").serialize(),//数据，这里使用的是Json格式进行传输  \r\n");
      out.write("                    success : function(result) {//返回数据根据结果进行相应的处理  \r\n");
      out.write("                        if (result==\"success\") {  \r\n");
      out.write("                            alert(\"保存成功\");\r\n");
      out.write("                        } else {  \r\n");
      out.write("                            alert(result);\r\n");
      out.write("                        }  \r\n");
      out.write("                    }  \r\n");
      out.write("                });  \r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$('#file').change(function() {\r\n");
      out.write("\t\t\t uploadFile(\"file\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction uploadFile(fileId) {\r\n");
      out.write("          $.ajaxFileUpload\r\n");
      out.write("          (\r\n");
      out.write("              {\r\n");
      out.write("                  url: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/file/uploadFile?prePath=content', //用于文件上传的服务器端请求地址\r\n");
      out.write("                  secureuri: false, //是否需要安全协议，一般设置为false\r\n");
      out.write("                  fileElementId: fileId, //文件上传域的ID\r\n");
      out.write("                  dataType: 'json', //返回值类型 一般设置为json\r\n");
      out.write("                  success: function (data)  //服务器成功响应处理函数\r\n");
      out.write("                  {\r\n");
      out.write("                     $.each(data,function(i,n){\r\n");
      out.write("                     \t\tsavePicture(n);\r\n");
      out.write("                     });\r\n");
      out.write("                     \r\n");
      out.write("                  }\r\n");
      out.write("              }\r\n");
      out.write("          )\r\n");
      out.write("          return false;\r\n");
      out.write("      }\r\n");
      out.write("      \r\n");
      out.write("      function savePicture(data){\r\n");
      out.write("\t\t        var fileParent=$(\"#file\").parent();\r\n");
      out.write("\t\t        $(\"#file\").remove();\r\n");
      out.write("\t\t        $(fileParent).append(\"<input type='file' name='files' id='file'>\");\r\n");
      out.write("\t\t        var fileName=data.fileName;\r\n");
      out.write("\t\t        var filePath=data.filePath;\r\n");
      out.write("\t\t        $(fileParent).find(\"input[name='logo']\").val(filePath);\r\n");
      out.write("\t\t        $(fileParent).find(\"img\").attr(\"src\",\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"+filePath);\r\n");
      out.write("\t\t        \r\n");
      out.write("      }\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /WEB-INF/modules/sys/common.jsp(6,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("ctx");
    // /WEB-INF/modules/sys/common.jsp(6,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/modules/sys/common.jsp(6,0) '${pageContext.request.contextPath }'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f1.setParent(null);
    // /WEB-INF/modules/sys/common.jsp(7,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setVar("ctxStatic");
    // /WEB-INF/modules/sys/common.jsp(7,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/modules/sys/common.jsp(7,0) '${pageContext.request.contextPath }/static'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath }/static",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f1 = _jspx_th_c_005fset_005f1.doStartTag();
    if (_jspx_th_c_005fset_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f2.setParent(null);
    // /WEB-INF/modules/sys/common.jsp(8,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setVar("site");
    // /WEB-INF/modules/sys/common.jsp(8,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/modules/sys/common.jsp(8,0) '${fns:getSiteById(1)}'",_el_expressionfactory.createValueExpression(new org.apache.jasper.el.ELContextWrapper(_jspx_page_context.getELContext(),_jspx_fnmap_0),"${fns:getSiteById(1)}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f2 = _jspx_th_c_005fset_005f2.doStartTag();
    if (_jspx_th_c_005fset_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f2);
    return false;
  }
}