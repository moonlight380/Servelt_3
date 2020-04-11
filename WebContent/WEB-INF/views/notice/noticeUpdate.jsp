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
		<h1>pointUpdate Form</h1>
		
		<form action="./noticeUpdate" method="post">

    <div class="form-group">
      <label for="no">No:</label>
      <input type="text" class="form-control" id="no" placeholder="Enter no" name="no" value="${ndto.no}"readonly="readonly" >
    </div>
    <div class="form-group">
      <label for="subject">Subject:</label>
      <input type="text" class="form-control" id="subject" placeholder="Enter subject" name="subject" value="${ndto.subject}" >
    </div>
    <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name" value="${ndto.name}" readonly="readonly">
    </div>
    <div class="form-group">
      <label for="day">Day:</label>
      <input type="date" class="form-control" id="day" placeholder="Enter day" name="day" value="${ndto.day}">
    </div>
    <div class="form-group">
      <label for="hit">Hit:</label>
      <input type="text" class="form-control" id="hit" placeholder="Enter hit" name="hit" value="${ndto.hit}">
    </div>

    
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
		
		
</div>
</div>
</body>
</html>