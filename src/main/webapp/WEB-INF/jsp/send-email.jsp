<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>try</title>
<link href="css/customstyle.css" rel="stylesheet" type="text/css">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">

    <script src="bootstrap/js/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="row">
<div class="col-md-3">
</div>
<div class="col-md-6">
<h3 class="text-center">Type your email info for opt</h3>
<form action="/invmgtsys/send-email" method="GET">
<label>To:</label>
<input type="text"  class="form-control" name="receiver"><br>
<label>Subject:</label>
<input type="text"  class="form-control" name="subject"><br>
<label>Compose Email:</label>
<textarea name="message" rows="4" cols="50"></textarea><br>
<input type="submit" class="btn btn-primary">
</div>
<div class="col-md-3">
</div>
</div>
