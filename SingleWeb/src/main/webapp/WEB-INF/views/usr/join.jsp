<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h1>Join Page</h1>
ID&nbsp;:&nbsp;
<input type="text" name="userId" id="userId" value="single" />
<br />

NAME&nbsp;:&nbsp;
<input type="text" name="userName" id="userName" value="single" />
<br />

PASSWORD&nbsp;:&nbsp;
<input type="text" name="userPassword" id="userPassword" value="single" />
<br />

PHONE&nbsp;:&nbsp;
<input type="text" name="userPhone" id="userPhone" value="single" />
<br />

MAIL&nbsp;:&nbsp;
<input type="text" name="userEmail" id="userEmail" value="single" />
<br />
<a href="javascript:;" onclick="javascript:fn_join_submit();"><span>가입</span></a>
<br />
<a href="javascript:;" onclick="javascript:fn_join_submit_reset();"><span>취소</span></a>
<br />

<form id="doIndex" action="/index.do"></form>