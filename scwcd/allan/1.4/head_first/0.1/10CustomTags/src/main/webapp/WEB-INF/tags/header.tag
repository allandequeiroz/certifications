<%@ attribute name="title" required="true" rtexprvalue="true"%>
<%@ tag body-content="tagdependent"%>

<table width="100%" height="80" bgcolor="#cbcbcb">
	<tr align="center">
		<td><h4>${title}</h4></td>
	</tr>
	<tr align="center">
		<td><jsp:doBody/></td>
	</tr>
</table>