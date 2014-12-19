<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script>

function fn_join_submit()
{
	$('#joinForm').submit();
}

</script>


<h1>Join Page</h1>
<form id="joinForm" name="joinForm" action="/usr/doJoin.do">
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
<input type="text" name="userMail" id="userMail" value="single" />
<br />
</form>
<a href="javascript:;" onclick="javascript:fn_join_submit();"><span>가입</span></a>
<br />
<a href="javascript:;" onclick="javascript:fn_reset();"><span>취소</span></a>
<br />

