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
		<h1>pointMod Form</h1>
		
		<form action="./pointMod" method="post">

    <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name" value="${dto.name}" >
    </div>
    <div class="form-group">
      <label for="num">Num:</label>
      <input type="text" class="form-control" id="num" placeholder="Enter num" name="num" value="${dto.num}" readonly="readonly">
    </div>
    <div class="form-group">
      <label for="kor">Kor:</label>
      <input type="text" class="form-control" id="kor" placeholder="Enter kor" name="kor" value="${dto.kor}">
    </div>
    <div class="form-group">
      <label for="eng">Eng:</label>
      <input type="text" class="form-control" id="eng" placeholder="Enter eng" name="eng" value="${dto.eng}">
    </div>
    <div class="form-group">
      <label for="math">Math:</label>
      <input type="text" class="form-control" id="math" placeholder="Enter math" name="math" value="${dto.math}">
    </div>
    <div class="form-group">
      <label for="Total">Total:</label>
      <input type="text" class="form-control" id="total" placeholder="Enter total" name="total" value="${dto.total}">
    </div>   
    <div class="form-group">
      <label for="avg">Avg:</label>
      <input type="text" class="form-control" id="avg" placeholder="Enter avg" name="avg" value="${dto.avg}">
    </div>
    
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
		
		
</div>
</div>
</body>
</html>