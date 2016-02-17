<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<header>
		<title>Show01</base>
	</header>
	<body>
		<jsp:useBean id="people" type="java4.fun.bean.People" class="java4.fun.bean.People" scope="session" />
		
		<jsp:getProperty name="people" property="name" />
		<jsp:getProperty name="people" property="surename" />
		<jsp:getProperty name="people" property="age" />
	</body>  
</html>