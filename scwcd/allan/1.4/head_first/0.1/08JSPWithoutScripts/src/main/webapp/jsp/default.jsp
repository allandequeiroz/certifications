<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"--%>
<%--@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"--%>
<html>
	<header>
		<title>DEFAULT</base>
	</header>
	<body>
		<!--form method="post" action="${pageContext.request.contextPath}/skaterFormController"-->
		<form method="post" action="${pageContext.request.contextPath}/jsp/viewerResults.jsp">
			<b>Skater</b> 
			<table>
				<tr>
					<td>Name : </td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>Surename : </td>
					<td><input type="text" name="surename"></td>
				</tr>
				<tr>
					<td>Age : </td>
					<td><input type="text" name="age"></td>
				</tr>
				<tr>
					<td>Sponsors - <i>Separated by <b>;</b></i></td>
					<td><input type="text" name="sponsors"></td>
				</tr>
			</table>
			<input type="submit" value="Send">
		</form> 
		<hr/>
		<a href="${pageContext.request.contextPath}/elController">El</a><br/>
		<a href="${pageContext.request.contextPath}/jsp/elFuncions.jsp">El Functions</a><br/>
	</body>
</html>