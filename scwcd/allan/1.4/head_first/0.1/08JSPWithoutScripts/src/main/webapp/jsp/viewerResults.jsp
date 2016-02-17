<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"--%>
<%--@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"--%>
<html>
	<header>
		<title>DEFAULT</base>
	</header>
	<body>
		<jsp:useBean id="skater" class="java4.fun.bean.Skater" type="java4.fun.bean.People" scope="request" >
			<%--jsp:setProperty name="skater" property="name"/>
			<jsp:setProperty name="skater" property="surename"/>
			<jsp:setProperty name="skater" property="age"/--%>
			<jsp:setProperty name="skater" property="*"/>
		</jsp:useBean> 
		
		<table>
				<tr>
					<td>Name : </td>
					<td><jsp:getProperty name="skater" property="name" /></td>
				</tr>
				<tr>
					<td>Surename : </td>
					<td><jsp:getProperty name="skater" property="surename" /></td>
				</tr>
				<tr>
					<td>Age : </td>
					<td><jsp:getProperty name="skater" property="age" /></td>
				</tr>
				<!--tr>
					<td>Sponsors :</td>
					<td><jsp:getProperty name="skater" property="name" /></td>
				</tr-->
			</table>
	</body>
</html>