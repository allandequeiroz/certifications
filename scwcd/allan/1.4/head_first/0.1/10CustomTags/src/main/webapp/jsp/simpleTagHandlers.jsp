<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="s" uri="http://java4.fun/jsp/jstl/handler/simple" %>
<html>
	<header>
		<title>Simple Handlers</base>
	</header>
	<body>
	
	<c:set var="name" value="Allan de Queiroz" scope="request" />
	<c:set var="publisher" value="Dicas-L" scope="request" />
	<c:set var="url" value="http://www.dicas-l.com.br/index.xml" scope="request" />
	
	<s:simple user="${name}" publisher="${publisher}" url="${url}" >
		This is the tag body!
	</s:simple>
		
	</body>
</html>