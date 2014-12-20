<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<h1>Find User Info Page</h1>

<div id="userInfoArea"></div>

NAME&nbsp;:&nbsp;
<input type="text" name="userName" id="userName" value="single" />
<br />

PHONE&nbsp;:&nbsp;
<input type="text" name="userPhone" id="userPhone" value="single" />
<br />

EMAIL&nbsp;:&nbsp;(개필수값_디비_unique값임)
<input type="text" name="userEmail" id="userEmail" value="single" />
<br />

<a href="javascript:;" onclick="javascript:fn_find_submit();"><span>정보
		찾기</span></a>
<br />
<a href="javascript:;" onclick="javascript:fn_find_submit_reset();"><span>취소</span></a>
<br />

<form id="doIndex" action="/index.do"></form>