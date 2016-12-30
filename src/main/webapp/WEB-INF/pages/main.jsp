<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head></head>
<body>
Welcome ${username}!
<br/>
This is the main page!
	<c:if test="${pageContext.request.userPrincipal.name != null}">
       <form id="logoutForm" method="POST" action="${pageContext.request.contextPath}/logout">
           <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
       </form>

       <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>

   </c:if>
</body>
</html>