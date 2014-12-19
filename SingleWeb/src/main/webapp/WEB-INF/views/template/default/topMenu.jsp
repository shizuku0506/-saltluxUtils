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
<a href="/usr/doLogout.do">loginOut</a>&nbsp;|&nbsp;
<%		
	}
%>
<a href="javascript:;">site map</a>