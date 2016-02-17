<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<html>
	<header>
		<title>DEFAULT</base>
	</header>
	<body>
		${skater.name} ${skater.surename}, ${skater.age} years old! <br/>
		
		<c:set var="indexNumber" scope="page" value="0" /> 
		<c:forEach var="sponsor" items="${skater.sponsorsArray}" varStatus="index">
			<c:if test="${(indexNumber % 2) == 0}">
				<i>${index.count})${sponsor.name}&nbsp;</i>
			</c:if>
			<c:set var="indexNumber" scope="page" value="${indexNumber+1}" /> 
		</c:forEach>
		
		<hr/>
		
		<c:set var="indexNumber" scope="page" value="0" /> 
		<c:forEach var="sponsor" items="${skater.sponsorsArray}" varStatus="index">
			<c:choose>
				<c:when test="${(indexNumber mod 2) eq 0}">
					<i>${index.count})${sponsor.name}&nbsp;</i>
				</c:when>
				<c:otherwise>
					${index.count})${sponsor.name}&nbsp;
				</c:otherwise>
			</c:choose>
			<c:set var="indexNumber" scope="page" value="${indexNumber+1}" /> 
		</c:forEach>
		
		<hr/>
		
		${skater["sponsorsMap"]["Almost"]["name"]} - 
		${skater["sponsorsMap"]["Almost"]["creation"]}
		
		<hr/>
		
		<c:import url="fragments/cImportTestFragment.jsp">
			<c:param name="title" value="I'm a fragment, I'm receive this text by parameter!" />
		</c:import>		
		
		<hr/>
		
		<c:url value="fragments/cImportTestFragment.jsp?name=${skater.name}&surename=${skater.surename}" var="fragmentUrl" />
		New url fragment : ${fragmentUrl}
	</body>
</html>