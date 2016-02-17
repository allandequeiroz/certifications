<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="u" uri="http://java4.fun/jsp/jstl/utils" %>
<html>
	<header>
		<title>Rss URL viewer</base>
	</header>
	<body>
		<u:reader user="${param.name}" publisher="${param.publisher}" url="${param.url}" />
	</body>
</html>