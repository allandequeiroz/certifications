<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"--%>
<%--@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"--%>
<html>
	<header>
		<title>DEFAULT</base>
	</header>
	<body>
		
		${requestScope.skaterRequest.name}
		${sessionScope.skaterSession.surename},
		${applicationScope.skaterContext.age} years old.<br/>
		${param.skaterParam} : ${cookie.skaterCookie.value}
		
		<hr>
		
		${requestScope["skaterRequest"]["name"]}
		${sessionScope["skaterSession"]["surename"]},
		${applicationScope["skaterContext"]["age"]} years old.<br/>
		${param["skaterParam"]} : ${cookie["skaterCookie"]["value"]}
		
		<hr>
		
		${requestScope["skaterRequest"]["sponsorsArray"][0]["name"]},
		${requestScope["skaterRequest"]["sponsorsArray"][1]["name"]}<br/>
		${requestScope["skaterRequest"]["sponsorsArray"]["1"]["name"]},
		${requestScope["skaterRequest"]["sponsorsArray"][0]["name"]}
		
		<hr>
		
		${requestScope["skaterRequest"]["sponsorsMap"]["Adio"]["name"]},
		${requestScope["skaterRequest"]["sponsorsMap"]["Almost"]["name"]}
		
	</body>
</html>