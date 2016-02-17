<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"--%>
<%--@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"--%>
<html>
	<header>
		<title>Using Post</base>
	</header>
	<body>
		<form method="POST" action="${pageContext.request.contextPath}/usingPost">
			<table>
				<tr>
					<td>Name &nbsp;&nbsp;</td><td><input type="text" name="name" size="30" colspan="2"></td><td></td>
				</tr>
				<tr>
					<td>Surename &nbsp;&nbsp;</td><td><input type="text" name="surename" size="30" colspan="2"></td><td></td>
				</tr>
				<tr>
					<td>Colors</td>
					<td>
						Green<input type="checkbox" name="colors" value="green"> &nbsp;&nbsp;
						Red<input type="checkbox" name="colors" value="red"> &nbsp;&nbsp;
						Blue<input type="checkbox" name="colors" value="blue"> &nbsp;&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="Send">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>