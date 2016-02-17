<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<header>
		<title>Rss URL Form</base>
	</header>
	<body>
		<form method="post" action="jsp/rssURLViewer.jsp">
			<table>
				<tr>
					<td>Your name :</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>Publisher</td>
					<td><input type="text" name="publisher"></td>
				</tr>
				<tr>
					<td colspan="2"><i>Insert here the rss URL:</i></td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" size="80" name="url"></td>
				</tr>
			</table>
			<input type="submit" value="Send" />
		</form>
	</body>
</html>