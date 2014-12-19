<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h1>Login Page</h1>
<form id="loginForm" action="/usr/doLogin.do" method="post">
	ID&nbsp;:&nbsp; <input type="text" name="userId" id="userId"
		value="single" /> <br /> PASSWORD&nbsp;:&nbsp; <input type="text"
		name="userPassword" id="userPassword" value="single" /> <br />
</form>

<a href="javascript:;" onclick="javascript:fn_login_submit();"><span>로그인</span></a>
<br />
<a href="/usr/findUserInfo.do"><span>ID/PASSWORD&nbsp;찾기</span></a>
<br />
<form id="doIndex" action="/index.do"></form>