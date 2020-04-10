<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import> 
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container">
	
	<h1>notice Add Form</h1>
 <form action="./noticeAdd" method="post">

    <div class="form-group">
      <label for="name">no:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
    </div>
    <div class="form-group">
      <label for="num">subject:</label>
      <input type="text" class="form-control" id="num" placeholder="Enter num" name="num">
    </div>
    <div class="form-group">
      <label for="kor">name:</label>
      <input type="text" class="form-control" id="kor" placeholder="Enter kor" name="kor">
    </div>
    <div class="form-group">
      <label for="eng">day:</label>
      <input type="text" class="form-control" id="eng" placeholder="Enter eng" name="eng">
    </div>
    <div class="form-group">
      <label for="math">hit:</label>
      <input type="text" class="form-control" id="math" placeholder="Enter math" name="math">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
	
	
	
</body>
</html>