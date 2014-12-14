<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head>
	<title>SingleWeb</title>
</head>

<body>
<table border="1" style="border-collapse: collapse;" align="center" width="800">
	<tbody>
		<tr>
			<td height="30" colspan="2">
				<tiles:insertAttribute name="header"/>
			</td>
		</tr>
		<tr>
			<td width="150" height="450" valign="top">
				<tiles:insertAttribute name="menu"/>
			</td>
			<td valign="top" width="650">
				<tiles:insertAttribute name="content"/>
			</td>
		</tr>
		<tr>
			<td height="30" colspan="2">
				<tiles:insertAttribute name="footer"/>
			</td>
		</tr>
	</tbody>
</table>
</body>
</html>