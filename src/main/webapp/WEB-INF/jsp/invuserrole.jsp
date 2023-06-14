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
          <a class="nav-link active" href="http://localhost:8080/invmgtsys/invuserrole">Roles</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="http://localhost:8080/invmgtsys/invuser">User</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="http://localhost:8080/invmgtsys/report">Report</a>
        </li>
      </ul>
    </nav>
    <br>
&nbsp;&nbsp;
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#add-roles-model">
       Add roles
    </button>



<div class="container"  style="min-height:675px;">
<div class="row">
<table class="table">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Status</th>
        <th>Action</th>
        <th>Action</th>
    </tr>
    <c:forEach var="roles" items="${rolesList}">
      <tr>
        <td>${roles.id}</td>
          <td>${roles.name}</td>
          <td>${roles.status?'Enabled' : 'Disabled'}</td>
          <td><button onclick="updateRo('${roles.id}')" class="btn btn-primary">Edit</button></td>
           <td>   <form action="/invmgtsys/delete-roles" onsubmit="return confirmDeleteRoles('${roles.name}')" method="POST" >
                  <input type="hidden" name="id" value="${roles.id}">
                  <button type="submit" onclick="deleteRoles();" class="btn btn-primary">Delete</button>
              </form>
          </td>
        </tr>
    </c:forEach>
</table>
</div>
</div>




<div class="modal fade" id="add-roles-model" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Enter Roles Details</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-12 mx-auto">
                        <form action="/invmgtsys/add-roles" method="POST">

                            <div class="form-group">
                                <label for="Name">Name</label>
                                <input type="text" class="form-control" id="name" name="name" aria-describedby="firstName" placeholder="Enter first name">
                            </div>

                            <div class="form-check mb-3">
                                <input type="checkbox" class="form-check-input" name="status" id="status" value="1">
                                <label class="form-check-label">Show Roles</label>
                            </div>

                            <button type="button" class="btn btn-secondary" id="addCloseBtn" data-dismiss="modal">Close</button>
                            <button type="submit" name="addSells" class="btn btn-primary">Submit</button>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

<!-- update category model start -->
<div class="modal fade" id="updateRo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" >Update role detail</h5>

            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-12 mx-auto">
                        <form action="/invmgtsys/update-roles" method="POST">
                            <input type="hidden" name="id" id="id">

                            <div class="form-group">
                                <label for="Name">Name</label>
                                <input type="text" class="form-control" id="name" name="name" aria-describedby="name" placeholder="Enter role name">
                            </div>

                            <div class="form-check mb-3">
                                <input type="checkbox" class="form-check-input" name="status" id="status" value="1">
                                <label class="form-check-label" for="status">Show role</label>
                            </div>


                            <button type="button" class="btn btn-secondary" id="updateProductClose" dadata-bs-dismiss="modal">Close</button>
                            <button type="submit" name="updateProduct" class="btn btn-primary">Submit</button>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

                <script type="text/javascript" src="${pageContext.request.contextPath}/pagejs/update_roles.js"></script>
                <script>
                    function confirmDeleteRoles(name) {
                     // alert("Are you sure you want to disable "+name);
                        let msg ="Are you sure you want to disable "+name;
                        if (confirm(msg)== true) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                </script>




<div class="bg-dark" style="min-height:50px">
<p class="text-white text-center">&copy;2022 All right Reserved</p>
</div>

                </body>
                </html>