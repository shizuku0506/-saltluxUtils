'strict'

/*
 * 로그인 스크립트
 */
function fn_login_validate()
{
	if ($.trim($('#userId').val()) == '')
	{
		alert('Confirm Input box');
		$('#userId').focus();
		return false;
	}
	if ($.trim($('#userPassword').val()) == '')
	{
		alert('Confirm Input box');
		$('#userPassword').focus();
		return false;
	}
}
function fn_login_submit()
{
	if (fn_login_validate() == false)
	{
		return false;
	}

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
		
		alert(data.userVO.userId + '님 환영합니다.');
		$('#doIndex').submit();
	});
}
/*
 * 회원정보 찾기
 */
function fn_find_validate()
{
	if ($.trim($('#userName').val()) == '')
	{
		alert('Confirm Input box');
		$('#userName').focus();
		return false;
	}
	if ($.trim($('#userEmail').val()) == '')
	{
		alert('Confirm Input box');
		$('#userEmail').focus();
		return false;
	}
	if ($.trim($('#userPhone').val()) == '')
	{
		alert('Confirm Input box');
		$('#userPhone').focus();
		return false;
	}
}
function fn_find_submit()
{
	if (fn_find_validate() == false)
	{
		return false;
	}

	var param =
	{
	    userName : $('#userName').val(),
	    userEmail : $('#userEmail').val(),
	    userPhone : $('#userPhone').val()
	}
	$.post('/usr/doFindUserInfo.do', param, function(data)
	{
		$('#userInfoArea').html('');

		var innerHTML = '';

		if (data.isSuccess == false)
		{
			innerHTML += '조회정보가 없습니다.';
		} else
		{
			if (data.userVO != undefined)
			{
				innerHTML += 'User Id : ';
				innerHTML += data.userVO.userId;
				innerHTML += '<br/>';
				innerHTML += 'Password : ';
				innerHTML += data.userVO.userPassword;
				innerHTML += '<br/>';
			} else
			{
				innerHTML += '조회정보가 없습니다.';
			}
		}
		$('#userInfoArea').html(innerHTML);
	});
}

function fn_find_submit_reset()
{
	$('#userName').val('');
	$('#userEmail').val('');
	$('#userPhone').val('');
}
/*
 * 회원가입 스크립트
 */

function fn_join_validate()
{
	if ($.trim($('#userId').val()) == '')
	{
		alert('Confirm Input box');
		$('#userId').focus();
		return false;
	}
	if ($.trim($('#userName').val()) == '')
	{
		alert('Confirm Input box');
		$('#userName').focus();
		return false;
	}
	if ($.trim($('#userPassword').val()) == '')
	{
		alert('Confirm Input box');
		$('#userPassword').focus();
		return false;
	}
	if ($.trim($('#userEmail').val()) == '')
	{
		alert('Confirm Input box');
		$('#userEmail').focus();
		return false;
	}
	if ($.trim($('#userPhone').val()) == '')
	{
		alert('Confirm Input box');
		$('#userPhone').focus();
		return false;
	}
}
function fn_join_submit()
{
	if (fn_join_validate() == false)
	{
		return false;
	}
	var param =
	{
	    userId : $('#userId').val(),
	    userName : $('#userName').val(),
	    userPassword : $('#userPassword').val(),
	    userEmail : $('#userEmail').val(),
	    userPhone : $('#userPhone').val()
	}
	$.post('/usr/doJoin.do', param, function(data)
	{
		if (data.isSuccess == false)
		{
			if (data.duplicateCount > 0)
			{
				alert('이미 등록된 정보입니다.');
			} else
			{
				alert('가입 실패');
			}
			return false;
		} else
		{
			alert('가입을 환영합니다.');
			$('#doIndex').submit();
		}
	});
}
function fn_join_submit_reset()
{
	$('#userId').val('');
	$('#userName').val('');
	$('#userPassword').val('');
	$('#userEmail').val('');
	$('#userPhone').val('');
}