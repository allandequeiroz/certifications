<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<header>
		<title>Login</title>
	</header>
	<body>
		<form method="POST" action="j_security_check">
			<table>
				<tr>
					<td>Username : </td>
					<td><input type="text" name="j_username"/></td>
				</tr>
				<tr>
					<td>Password : </td>
					<td><input type="password" name="j_password"/></td>
				</tr>
			</table>
			<input type="submit" value="Login" />
		</form>
	</body>
</html>
