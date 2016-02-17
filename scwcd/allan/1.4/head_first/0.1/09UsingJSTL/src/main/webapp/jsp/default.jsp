<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<html>
	<header>
		<title>DEFAULT</base>
	</header>
	<body>
		<a href="${pageContext.request.contextPath}/jstl">JSTL</a><br/>
		
		<c:url value="jsp/urlWithParams.jsp" var="urlWithParams">
			<c:param name="newUrl" value="http://www.google.com" />
		</c:url>
		<a href="${urlWithParams}">Url With Params</a><br/>
		
		<a href="jsp/404ErrorGenerator.jsp">Error type mapped</a><br/>
		
		<a href="jsp/generalErrorGenerator.jsp">General error mapped</a><br/>
	</body>
</html>