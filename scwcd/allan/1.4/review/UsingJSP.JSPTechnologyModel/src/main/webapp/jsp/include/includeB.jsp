<table bgcolor="#ffff00" width="100%">
	<tr>
		<td>
			Hi! I'm B! ${param.paramB}
		</td>
	</tr>
</table>

<jsp:include page="includeC.jsp" >
	<jsp:param name="paramC" value="${param.paramC}" />
</jsp:include>