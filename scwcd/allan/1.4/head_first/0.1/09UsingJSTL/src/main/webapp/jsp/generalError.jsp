<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<header>
		<title>General Error</base>
	</header>
	<body>
		<b>YOU CAUSED A GENERAL ERROR : </b> ${pageContext.exception} <b>ON THE SERVER.</b>
	</body>
</html>