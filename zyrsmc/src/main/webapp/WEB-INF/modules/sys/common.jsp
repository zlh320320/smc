<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="https://zlh/fns/tld" prefix="fns" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<c:set var="ctxStatic" value="${pageContext.request.contextPath }/static"></c:set>
<c:set var="site" value="${fns:getSiteById(1)}"></c:set>


