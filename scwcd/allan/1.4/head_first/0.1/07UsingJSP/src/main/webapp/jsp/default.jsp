<%@ page import="java4.fun.help.Messages"%> <%-- Directive import --%>
<%@ page import="java.io.IOException"%> <%-- Directive import --%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"--%>
<%--@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"--%>
<html>
	<header>
		<title>All</title>
	</header>
	<body>
	
		Page accessed <%= count %> times! <%-- Expression --%>
		<br/>
		<% out.println(Messages.getMessage()); %> <%-- Scriptlet --%>
		<br/>
		<%= Messages.getMessage() %> <%-- Expression --%>
		
		<%! static int count=0; %> <%-- Declaration --%>
		<% count++; %> <%-- Scriptlet --%>
		
		<br/>
		
		<%!
			public void jspInit(){
				ServletConfig mConfig = getServletConfig();
				String email = mConfig.getInitParameter("email");
				System.out.println("\n" + email + "\n");
			}
		%> <%-- Declaration --%>
		
		Mail address from DD : <%= config.getInitParameter("email") %> <%-- Expression --%>
		<br/>
		Mail address from DD : <%= pageContext.getServletContext().getInitParameter("email") %> <%-- Expression --%>
		
	</body>
</html>