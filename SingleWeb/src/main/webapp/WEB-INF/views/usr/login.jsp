<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script>
	function fn_login_submit()
    {
	    // $('#loginForm').submit();

	    var param =
	    {
	        userId : $('#userId').val(),
	        userPassword : $('#userPassword').val()
	    }

	    $.post('/usr/doLogin.do', param, function(data)
	    {
		    if (data.isLogin == false)
		    {
			    alert('로그인 실패');
			    return false;
		    }
		    alert('로그인 성공');
		    $('#doIndex').submit();
	    });
    }
</script>
<h1>Login Page</h1>
<form id="loginForm" action="/usr/doLogin.do" method="post">
	ID&nbsp;:&nbsp; <input type="text" name="userId" id="userId" value="single" /> <br />
	PASSWORD&nbsp;:&nbsp; <input type="text" name="userPassword"
		id="userPassword" value="single" /> <br />
</form>

<a href="javascript:;" onclick="javascript:fn_login_submit();"><span>로그인</span></a>
<br />
<a href=""><span>ID/PASSWORD&nbsp;찾기</span></a>
<br />
<form id="doIndex" action="/index.do">
</form>