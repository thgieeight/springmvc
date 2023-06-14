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
          <a class="nav-link active" href="http://localhost:8080/invmgtsys/invuser">User</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="http://localhost:8080/invmgtsys/report">Report</a>
        </li>
      </ul>
    </nav>
    <br>
&nbsp;&nbsp;
    <button type="button" onclick="getRolesDropDown()" class="btn btn-primary" data-toggle="modal" data-target="#add-user-model">
       Add user
    </button>



<div class="container"  style="min-height:675px;">
<div class="row">
<table class="table">
    <tr>
        <th>Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Username</th>
        <th>Password</th>
        <th>Roles</th>
        <th>Action</th>
        <th>Action</th>
    </tr>
    <c:forEach var="user" items="${userList}">
      <tr>
        <td>${user.id}</td>
          <td>${user.firstName}</td>
          <td>${user.lastName}</td>
          <td>${user.email}</td>
          <td>${user.username}</td>
          <td>${user.password}</td>

       <td><c:forEach var="role" items="${user.roles}">
                                   <p>${role.name}</p>
                               </c:forEach>
                           </td>

          <td><button onclick="updateUser('${user.id}')" class="btn btn-primary">Edit</button> </td>
           <td>   <form action="/invmgtsys/delete-user" onsubmit="return confirmDeleteSells('${user.firstName}')" method="POST" >
                  <input type="hidden" name="id" value="${user.id}">
                  <button type="submit" onclick="deleteUser();" class="btn btn-primary">Delete</button>
              </form>
          </td>
        </tr>
    </c:forEach>
</table>
</div>
</div>




<div class="modal fade" id="add-user-model" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Enter User Details</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-12 mx-auto">
                        <form action="/invmgtsys/add-user" method="POST">
                             <div class="form-group">
                                <label for="productId">Select Roles</label>
                                <select class="form-control form-select" id="id" name="id" aria-label="Default select example">
                                <option selected>Select Roles</option>
                                </select>
                             </div>

                            <div class="form-group">
                                <label for="userName">First Name</label>
                                <input type="text" class="form-control" id="firstName" name="firstName" aria-describedby="firstName" placeholder="Enter first name">
                            </div>


                            <div class="form-group">
                                <label for="userName">Last Name</label>
                                <input type="text" class="form-control" id="lastName" name="lastName" aria-describedby="lastName" placeholder="Enter last name">
                            </div>


                            <div class="form-group">
                                <label for="userEmail">Email</label>
                                <input type="email" class="form-control" id="email" name="email" aria-describedby="email" placeholder="Enter email">
                            </div>



                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" id="password" name="password" aria-describedby="email" placeholder="Enter email">
                            </div>



                            <div class="form-group">
                                <label for="username">Username</label>
                                <input type="text" class="form-control" id="username" name="username" aria-describedby="username" placeholder="Enter username">
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

<!-- update sells model start -->
<div class="modal fade" id="updateUser" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                  <h5 class="modal-title" >Update User detail</h5>

                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <div class="col-md-12 mx-auto">
                                        <form action="/invmgtsys/update-user" method="POST" >
                                        <input type="hidden" id="id" name="id">
                                        <div class="form-group">
                                        <label for="roleId">Select Roles</label>
                                                                     <select class="form-control form-select" id="id" name="id" aria-label="Default select example">
                                                                     <option selected>Select Roles</option>
                                                                     </select>
                                                                  </div>

                                                                 <div class="form-group">
                                                                     <label for="userName">First Name</label>
                                                                     <input type="text" class="form-control" id="firstName" name="firstName" aria-describedby="firstName" placeholder="Enter first name">
                                                                 </div>


                                                                 <div class="form-group">
                                                                     <label for="userName">Last Name</label>
                                                                     <input type="text" class="form-control" id="lastName" name="lastName" aria-describedby="lastName" placeholder="Enter last name">
                                                                 </div>


                                                                 <div class="form-group">
                                                                     <label for="userEmail">Email</label>
                                                                     <input type="email" class="form-control" id="email" name="email" aria-describedby="email" placeholder="Enter email">
                                                                 </div>


                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" id="password" name="password" aria-describedby="email" placeholder="Enter email">
                            </div>



                            <div class="form-group">
                                <label for="username">Username</label>
                                <input type="text" class="form-control" id="username" name="username" aria-describedby="username" placeholder="Enter username">
                            </div>


                                            <button type="button" class="btn btn-secondary" id="updateSellsClose" dadata-bs-dismiss="modal">Close</button>
                                            <button type="submit" name="updateInvent.ory" class="btn btn-primary">Submit</button>
                                        </form>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <script src="pagejs/role_drop_down_selected.js"></script>
                <script type="text/javascript" src="${pageContext.request.contextPath}/pagejs/update_user.js"></script>
                <script>
                    function confirmDeleteUser(firstName) {
                     // alert("Are you sure you want to disable "+firstName);
                        let msg ="Are you sure you want to disable "+firstName;
                        if (confirm(msg)== true) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                </script>
                <script src="pagejs/role_drop_down.js"></script>



<div class="bg-dark" style="min-height:50px">
<p class="text-white text-center">&copy;2022 All right Reserved</p>
</div>

                </body>
                </html>