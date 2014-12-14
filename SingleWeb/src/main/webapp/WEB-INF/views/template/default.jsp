<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head>
<style type="text/css">
body {
	width: 960px;
}

.topMenu {
	padding-right: 20px;
	margin-bottom: 10px;
	float: right;
}

.header {
	border: black solid 1px;
	margin-bottom: 10px;
}

.menu {
	padding-left: 10px;
	border: black solid 1px;
	float: left;
	width: 180px;
}

.content {
	border: black solid 1px;
	float: inherit;
	margin-left: 200px;
}

.footer {
	border: black solid 1px;
	margin-top: 10px;
}

.clear {
	clear: both;
}
</style>
<title>SingleWeb</title>
</head>

<body>
	<div>
		<div class="topMenu">
			<tiles:insertAttribute name="topMenu" />
		</div>
		<div class="clear"></div>
		<div class="header">
			<tiles:insertAttribute name="header" />
		</div>
		<div class="clear"></div>
		<div class="menu">
			<tiles:insertAttribute name="menu" />
		</div>
		<div class="content">
			<tiles:insertAttribute name="content" />
		</div>
		<div class="clear"></div>
		<div class="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>