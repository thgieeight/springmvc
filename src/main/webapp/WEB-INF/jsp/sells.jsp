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
          <a class="nav-link active" href="http://localhost:8080/invmgtsys/sells">Sells</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="http://localhost:8080/invmgtsys/invuserrole">Roles</a>
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
    <button type="button" onclick="getInventoryDropDown()" class="btn btn-primary" data-toggle="modal" data-target="#add-sells-model">
       Add sells
    </button>


<div style="color:red;"> ${errorMessage}</div>
<div class="container"  style="min-height:675px;">
<div class="row">
<table class="table">
    <tr>
        <th>Id</th>
        <th>Customer Name</th>
        <th>Added Date</th>
        <th>Status</th>
        <th>Inventory</th>
        <th>Sell Quantity</th>
        <th>Sell Description</th>
        <th>Action</th>
        <th>Action</th>
    </tr>
    <c:forEach var="sells" items="${sellsList}">
      <tr>
        <td>${sells.sellsId}</td>
          <td>${sells.customerName}</td>
          <td>${sells.addedDate}</td>
          <td>${sells.status==1 ? 'Enabled' : 'Disabled'}
          <td>${sells.inventory.inventoryName}</td>
            <td>${sells.sellQty}</td>
            <td>${sells.descriptionName}</td>
          </td>

          <td><button onclick="updateSells('${sells.sellsId}')" class="btn btn-primary">Edit</button> </td>
           <td>   <form action="/invmgtsys/delete-sells" onsubmit="return confirmDeleteSells('${sells.customerName}')" method="POST" >
                  <input type="hidden" name="sellsId" value="${sells.sellsId}">
                  <button type="submit" onclick="deleteSells();" class="btn btn-primary">Delete</button>
              </form>
          </td>
        </tr>
    </c:forEach>
</table>
</div>
</div>




<div class="modal fade" id="add-sells-model" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Enter Sells Details</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-12 mx-auto">
                        <form action="/invmgtsys/add-sells" method="POST" enctype="multipart/form-data">
                             <div class="form-group">
                                                            <label for="productId">Select Inventory</label>
                                                            <select class="form-control form-select" id="inventoryId" name="inventoryId" aria-label="Default select example">
                                                                <option selected>Select Inventory</option>
                                                            </select>
                                                        </div>

                            <div class="form-group">
                                <label for="sellsName">Customer Name</label>
                                <input type="text" class="form-control" id="customerName" name="customerName" aria-describedby="sellsName" placeholder="Enter sells name">
                            </div>

                            <div class="form-group">
                                                            <label for="Quantity">Sell Quantity</label>
                                                            <input type="text" class="form-control" id="sellQty" name="sellQty" aria-describedby="Quantity" placeholder="Enter Quantity Amount">
                                                        </div>

                                   <div class="form-group">
                                                                                               <label for="Description">Sell Description</label>
                                                                                               <input type="textarea" class="form-control" id="descriptionName" name="descriptionName" aria-describedby="descriptionName" placeholder="Enter descriptionName">
                                                                                           </div>

                                   <div class="form-group">
                                                                                               <label for="Date">Sell Date</label>
                                                                                               <input type="text" class="form-control" id="addedDate" name="addedDate" aria-describedby="descriptionName" placeholder="Enter descriptionName">
                                                                                           </div>

                            <div class="form-check mb-3">
                                <input type="checkbox" class="form-check-input" name="status" id="status" value="1">
                                <label class="form-check-label">Show Sells</label>
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
<div class="modal fade" id="updateSells" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Update sells detail</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="CLose">
                <span aria-hidden="true">&times;</span>

                </button>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <div class="col-md-12 mx-auto">
                                        <form action="/invmgtsys/update-sells" method="POST" enctype="multipart/form-data" >
                                        <input type="hidden" id="sellsId" name="sellsId">
                                      <div class="form-group">
                                                                                                  <label for="productId">Select Inventory</label>
                                                                                                  <select class="form-control form-select" id="updateInventoryId" name="inventoryId" aria-label="Default select example">
                                                                                                      <option selected>Select Inventory</option>
                                                                                                  </select>
                                                                                              </div>

                                                                  <div class="form-group">
                                                                      <label for="sellsName">Customer Name</label>
                                                                      <input type="text" class="form-control" id="updateCustomerSellsName" name="customerName" aria-describedby="sellsName" placeholder="Enter sells name">
                                                                  </div>

                                                                  <div class="form-group">
                                                                                                  <label for="Quantity">Sell Quantity</label>
                                                                                                  <input type="text" class="form-control" id="updateQuantity" name="sellQty" aria-describedby="Quantity" placeholder="Enter Quantity Amount">
                                                                                              </div>

                                                                         <div class="form-group">
                                                                                                                                     <label for="Description">Sell Description</label>
                                                                                                                                     <input type="textarea" class="form-control" id="updatedescriptionName" name="descriptionName" aria-describedby="descriptionName" placeholder="Enter descriptionName">
                                                                                                                                 </div>

                                                                  <div class="form-check mb-3">
                                                                      <input type="checkbox" class="form-check-input" name="status" id="updatestatus" value="1">
                                                                      <label class="form-check-label">Show Sells</label>
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
                <script src="pagejs/inventory_drop_down_selected.js"></script>
                <script type="text/javascript" src="${pageContext.request.contextPath}/pagejs/update_sells.js"></script>
                <script>
                    function confirmDeleteSells(sellsName) {
                     // alert("Are you sure you want to disable "+sellsName);
                        let msg ="Are you sure you want to disable "+sellsName;
                        if (confirm(msg)== true) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                </script>
                <script src="pagejs/inventory_drop_down.js"></script>


<div class="bg-dark" style="min-height:50px">
<p class="text-white text-center">&copy;2022 All right Reserved</p>
</div>

                </body>
                </html>