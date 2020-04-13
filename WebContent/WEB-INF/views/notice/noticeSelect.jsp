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
	<h1>Notice Select Page</h1>
		<table class="table table-hover">
		<tr>
			<td>no</td>
			<td>subject</td>
			<td>name</td>
			<td>day</td>
			<td>hit</td>
		</tr>
		
				<tr class="info">
					<td>${ndto.no}</td>
					<td>${ndto.subject}</td>
					<td>${ndto.name}</td>
					<td>${ndto.day}</td>
					<td>${ndto.hit}</td>
				</tr>	
		
		<tr>
			<td>body memo</td>
		</tr>
				
		<tr class="info">
			
			
			<td> ${ndto.body}</td>
			
		</tr>
			
		
		</table>
		<!-- //수정 폼이 나와야 하는데 전에 넣엇넌 내용들이 나와야 함...  -->
		 <a href="./noticeUpdate?no=${ndto.no}" class= "btn btn-primary">UPDATE</a>
		<button class ="btn btn-danger" id="del">DELETE</button>
	</div>
</div>


<script type="text/javascript">
$('#del').click(function(){
	var result=confirm("정말 삭제하시겠습니까?");
	if(result){
		 location.href="./noticeDelete"
	}else{
		location.href="#";
	}
});



</script>
</body>
</html>