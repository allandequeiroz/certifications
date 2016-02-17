<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"--%>
<%--@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"--%>
<html>
	<form method="post" action="${pageContext.request.contextPath}/formServlet">
		<table>
			<tr>
				<td><b>Name : </b></td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td><b>Surename : </b></td>
				<td><input type="text" name="surename"></td>
			</tr>
		</table>
		<input type="submit" value="Send">
	</form>
</html>