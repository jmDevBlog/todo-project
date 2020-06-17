<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TO-DO list</title>
<style>
/* 노말라이즈 */
body, ul, li {
	margin: 0;
	padding: 0;
	list-style: none;
}
/* 라이브러리 */
.con{
	margin-left: auto;
	margin-right: auto;
}
/* 커스텀 */
.con{
	width: 1000px;
}
.list-box-1>table{
	width: 100%;
	border-collapse: collapse;
}
.list-box-1>table th, .list-box-1>table td{
	border: 1px solid black;
	padding: 10px;
	font-weight: bold;
}

.list-box-1>table tbody > tr > td:not(:last-child){
	text-align: center;
}

</style>



</head>
<body>
	<h1 class="con">TODO리스트</h1>
	
	<div class="btns con">
		<a href="./create">할 일 추가</a>		
	</div>
	
	<h2 class="con">전체 게시물 개수 : ${totalCount}</h2>
	
	<div class="con list-box-1">
	
		<table>
			<colgroup>
				<col width = "100">
				<col width = "200">	
			</colgroup>
			<thead>	
				<tr>
					<th>ID</th>
					<th>제목</th>
					<th>시작 날짜</th>
					<th>마감 날짜</th>
					<th>상태</th>
					<th>수정/삭제</th>
				</tr>	
			</thead>
			<tbody>
				<c:forEach items="${articleList}" var="article">
					<tr>
						<td>${article.id}</td>
						<td>${article.title}</td>
						<td>${article.sdate }</td>
						<td>${article.ddate }</td>
						<td><a href="./done?id=${article.id }">${article.done }</a></td>
						<td><a href="./modify?id=${article.id}">수정</a> / <a href="./doDelete?id=${article.id}">삭제</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


</body>
</html>