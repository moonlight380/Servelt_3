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

<!--      <div class="form-group">
      <label for="no">no:</label>
      <input type="text" class="form-control" id="no" placeholder="Enter no" name="no"  >
    </div>  -->
    <div class="form-group">
      <label for="subject">subject:</label>
      <input type="text" class="form-control" id="subject" placeholder="Enter subject" name="subject">
    </div>
<!--      <div class="form-group">
      <label for="name">name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name"  >
    </div>  -->
<!--    <div class="form-group">
      <label for="day">day:</label>
      <input type="date" class="form-control" id="day" placeholder="Enter day" name="day"  >
    </div>  --> 
    <div class="form-group">
      <label for="hit">hit:</label>
      <input type="text" class="form-control" id="hit" placeholder="Enter hit" name="hit">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
	
	
	
</body>
</html>