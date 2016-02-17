<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<header>
		<title>Forward</title>
	</header>
	<body>
		<form method="post" action="forward.jsp">
			<table>
				<tr>
					<td>Name : </td>
					<td><input type="text" name="name" value="Allan"/></td>
				</tr>
				<tr>
					<td>Surename : </td>
					<td><input type="text" name="surename" value="de Queiroz"/></td>
				</tr>
				<tr>
					<td>Age : </td>
					<td><input type="text" name="age" value="25"/></td>
				</tr>
			</table>
			<input type="submit" value="Send" />
		</form>
	</body>
</html>