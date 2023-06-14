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
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
      <a class="navbar-brand" href="#">INV-MGT-SYS</a>

      <!-- Links -->
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="http://localhost:8080/invmgtsys/index">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="http://localhost:8080/invmgtsys/category">Category</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="http://localhost:8080/invmgtsys/product">Product</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="http://localhost:8080/invmgtsys/inventory">Inventory</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="http://localhost:8080/invmgtsys/sells">Sells</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="http://localhost:8080/invmgtsys/invuserrole">Roles</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="http://localhost:8080/invmgtsys/invuser">User</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="http://localhost:8080/invmgtsys/report">Report</a>
        </li>
      </ul>
    </nav>
    <br>

    <div class="container"  style="min-height:675px;">
    <div class="row">
<table class="table">
    <tr>
        <th>Id</th>
        <th>Options</th>
        <th>Category</th>
        <th>Product</th>
        <th>Inventory</th>
        <th>Sells</th>
    </tr>
      <tr>
        <td>1</td>
        <td>Download</td>
          <td><a href="http://localhost:8080/invmgtsys/category/export/excel"><button class="btn btn-success">Download</button></a></td>
          <td><a href="http://localhost:8080/invmgtsys/product/export/excel"><button class="btn btn-success">Download</button></a></td>
          <td><a href="http://localhost:8080/invmgtsys/inventory/export/excel"><button class="btn btn-success">Download</button></a></td>
          <td><a href="http://localhost:8080/invmgtsys/sells/export/excel"><button class="btn btn-success">Download</button></a></td>
      </tr>
      <tr>
        <td>1</td>
        <td>View</td>
          <td><a href="http://localhost:8080/invmgtsys/category-pdf"><button class="btn btn-success">Open</button></a></td>
          <td><a href="http://localhost:8080/invmgtsys/product-pdf"><button class="btn btn-success">Open</button></a></td>
          <td><a href="http://localhost:8080/invmgtsys/inventory-pdf"><button class="btn btn-success">Open</button></a></td>
          <td><a href="http://localhost:8080/invmgtsys/sells-pdf"><button class="btn btn-success">Open</button></a></td>
      </tr>
</table>
</div>
</div>




<div class="bg-dark" style="min-height:50px">
<p class="text-white text-center">&copy;2022 All right Reserved</p>
</div>
</body>
</html>