<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import> 
</head>
<body>
<c:import url="../template/header.jsp"></c:import>


<div class="container">
	<div class="row">
		<h1>Notice List Page</h1>
		<table class="table table-hover">
		<tr>
			<td>no</td>
			<td>subject</td>
			<td>name</td>
			<td>day</td>
			<td>hit</td>
		</tr>
		
		<c:forEach items="${noticeList}" var="ndto"> <!-- requestScope.는 안써도 무방 -->
			<tr>
				<td>${ndto.no}</td>
				<td><a href="./noticeSelect?no=${ndto.no}">${ndto.subject}</a></td>
				<td>${ndto.name}</td>
				<td>${ndto.day}</td>
				<td>${ndto.hit}</td>
			</tr>		
		</c:forEach>
		</table>
		
	<c:if test="${not empty sessionScope.member}">  <!-- name이 null이 아니면 --> 
    	 <c:if test="${member.name eq 'admin'}"> 
     <a href="./noticeAdd?" class= "btn btn-primary">Notice Add</a>
  
        </c:if> 
	</c:if>   
		
	
	</div>
</div>






	
</body>
</html>