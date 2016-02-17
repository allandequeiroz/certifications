<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<header>
		<title>Show01</base>
	</header>
	<body>
		Hi! I'm the Main!
		
		<jsp:include page="include/includeA.jsp" >
			<jsp:param name="paramA" value="param A from Main!" />
			<jsp:param name="paramB" value="param B from Main!" />
			<jsp:param name="paramC" value="param C from Main!" />
		</jsp:include>
		
	</body>
</html>