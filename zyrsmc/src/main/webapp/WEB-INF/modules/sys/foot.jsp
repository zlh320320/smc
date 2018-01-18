<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="https://zlh/fns/tld" prefix="fns" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<c:set var="ctxStatic" value="${pageContext.request.contextPath }/static"></c:set>
<div class="footer-bg" style="clear: both">
        <div class="w-content m-center footer">
            <div class="footer_main">
                <a class="footer_link" href="#">关于我们</a> <a class="footer_link" href="#">免责声明</a>
                <a class="footer_link" href="#">百科协议</a> <a class="footer_link" href="#">注册协议</a>
                <a class="footer_link" href="#">常见问题</a>
            </div>
            <div>
                <p>
                    地址：中国 江西省上饶县    备案号:赣ICP备16011326号-1
                </p>
            </div>
        </div>
    </div>

