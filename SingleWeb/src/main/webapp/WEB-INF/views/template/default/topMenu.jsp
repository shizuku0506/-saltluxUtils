<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@ page import="kr.pe.singleweb.cmm.usr.model.*" %>
<%
kr.pe.singleweb.cmm.usr.model.UserVO userVO = (UserVO) session.getAttribute("userVO");
String userId = StringUtils.defaultIfBlank(userVO.getUserId(), StringUtils.EMPTY);
boolean isLogin = true;
if(StringUtils.equals(userId, StringUtils.EMPTY) || StringUtils.equals(userId, "guest"))
{
	isLogin = false; 
}
%>

<%
	if(isLogin == false)
	{
%>
<a href="/usr/login.do">login</a>&nbsp;|&nbsp;
<a href="/usr/join.do">join</a>&nbsp;|&nbsp;
<%
	}else
	{
%>
	[&nbsp;<%=userVO.getUserId() %>&nbsp;]&nbsp;환영합니다.&nbsp;
	<a href="/usr/doLogout.do">loginOut</a>&nbsp;|&nbsp;
	
	<%
	if(userVO.getRollCode().equals("ROLL_000"))
	{
	%>
	<a href="/admin/admin.do">관리자&nbsp;페이지</a>&nbsp;|&nbsp;
	<%	
	}
	%>

<%		
	}
%>
<a href="javascript:;">site map</a>