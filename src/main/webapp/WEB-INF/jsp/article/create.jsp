<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TO-DO create</title>
<style>
	.con{
		width:1000px;
		margin: 0 auto;
	}
	
	.common-form > div > *{
		float:left;
	}
	
	.common-form > div::after{
		content:"";
		display:block;
		clear:both;
	}
	
	
	.common-form > div > span{
		width: 200px;
	}
	.common-form > div > div {
		width: calc(100% - 200px);
		
	}
	
	.common-form > div > div > input[type="text"]{
		width: 90%;
	}
	


</style>

</head>
<body>
	<h1>TODO 생성</h1>
	
	<script>
	function submitCreateForm(form){
		form.title.value = form.title.value.trim();
		if(form.title.value.length == 0){
			alert("주제를 입력해주세요");
			form.title.focus();

			return false;
		}
		
		form.submit();
	}
	</script>
	
	<form class="con common-form" action="./docreate" method="POST" onsubmit="submitCreateForm(this); return false;">
		<div>
			<span>
				주제
			</span>
			<div>
				<input name ="title" type="text" placeholder="주제작성" autofocus="autofocus">
			</div>
		</div>
		
		<div>
			<span>
				작성
			</span>
			<div>
				<input type="submit" value="작성">
				<input type="reset" value="취소" onclick="history.back();">
			</div>
		</div>
		
	</form>

</body>
</html>