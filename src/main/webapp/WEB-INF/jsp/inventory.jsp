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
          <a class="nav-link active" href="http://localhost:8080/invmgtsys/inventory">Inventory</a>
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
          <a class="nav-link" href="http://localhost:8080/invmgtsys/report">Report</a>
        </li>
      </ul>
    </nav>
    <br>
&nbsp;&nbsp;
    <button type="button" onclick="getProductDropDown()" class="btn btn-primary" data-toggle="modal" data-target="#add-inventory-model">
       Add inventory
    </button>



<div class="container">
<div class="row">
<table class="table">
    <tr>
        <th>Id</th>
        <th>Inventory Name</th>
        <th>Added Date</th>
        <th>Image</th>
        <th>Status</th>
        <th>Product</th>
        <th>Quantity</th>
        <th>Cost Price</th>
        <th>Selling Price</th>
        <th>Action</th>
        <th>Action</th>
    </tr>
    <c:forEach var="inventory" items="${inventoryList}">
      <tr>
        <td>${inventory.inventoryId}</td>
          <td>${inventory.inventoryName}</td>
          <td>${inventory.addedDate}</td>
          <td><img src="${request.contextPath}/invmgtsys/uploads/${inventory.image}" height="50px" width="50px"></td>
          <td>${inventory.status==1 ? 'Enabled' : 'Disabled'}
          <td>${inventory.product.productName}</td>
            <td>${inventory.quantity}</td>
                                    <td>${inventory.costPrice}</td>
                                     <td>${inventory.sellPrice}</td>


          </td>
          <td><button onclick="updateInventory('${inventory.inventoryId}')" class="btn btn-primary">Edit</button> </td>
           <td>   <form action="/invmgtsys/delete-inventory" onsubmit="return confirmDeleteInventory('${inventory.inventoryName}')" method="POST" >
                  <input type="hidden" name="inventoryId" value="${inventory.inventoryId}">
                  <button type="submit" onclick="deleteInventory();" class="btn btn-primary">Delete</button>
              </form>
          </td>
        </tr>
    </c:forEach>
</table>
</div>
</div>




<div class="modal fade" id="add-inventory-model" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Enter Inventory Details</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-12 mx-auto">
                        <form action="/invmgtsys/add-inventory" method="POST" enctype="multipart/form-data">
                             <div class="form-group">
                                                            <label for="productId">Select Product</label>
                                                            <select class="form-control form-select" id="productId" name="productId" aria-label="Default select example">
                                                                <option selected>Select Product</option>
                                                            </select>
                                                        </div>

                            <div class="form-group">
                                <label for="inventoryName">Inventory Name</label>
                                <input type="text" class="form-control" id="inventoryName" name="inventoryName" aria-describedby="inventoryName" placeholder="Enter inventory name">
                            </div>

                            <div class="form-group">
                                                            <label for="Quantity">Quantity</label>
                                                            <input type="text" class="form-control" id="quantity" name="quantity" aria-describedby="Quantity" placeholder="Enter Quantity Amount">
                                                        </div>
                            <div class="form-group">
                                                                                        <label for="costPrice">Cost Price</label>
                                                                                        <input type="text" class="form-control" id="costPrice" name="costPrice" aria-describedby="CostPrice" placeholder="Enter Cost Price in Rs.">
                                                                                    </div>

                            <div class="form-group">
                                                                                        <label for="SellPrice">Selling Price</label>
                                                                                        <input type="text" class="form-control" id="sellPrice" name="sellPrice" aria-describedby="SellPrice" placeholder="Enter Selling Price in Rs.">
                                                                                    </div>

                            <div class="form-group">
                                <label for="inventoryImage">Inventory Image</label>
                                <input type="file" class="form-control" id="inventoryImage" name="inventoryImage">
                            </div>

                            <div class="form-check mb-3">
                                <input type="checkbox" class="form-check-input" name="status" id="status" value="1">
                                <label class="form-check-label">Show Inventory</label>
                            </div>

                            <button type="button" class="btn btn-secondary" id="addCloseBtn" data-dismiss="modal">Close</button>
                            <button type="submit" name="addInventory" class="btn btn-primary">Submit</button>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

<!-- update inventory model start -->
<div class="modal fade" id="updateInventory" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Update inventory detail</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="CLose">
                <span aria-hidden="true">&times;</span>

                </button>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <div class="col-md-12 mx-auto">
                                        <form action="/invmgtsys/update-inventory" method="POST" enctype="multipart/form-data" >
                                        <input type="hidden" id="inventoryId" name="inventoryId">
                                        <div class="form-group">
                                                                                                    <label for="productId">Select Product</label>
                                                                                                    <select class="form-control form-select" id="updateProductId" name="productId" aria-label="Default select example">
                                                                                                        <option selected>Select Product to Update</option>
                                                                                                    </select>
                                                                                                </div>

                                         <div class="form-group">
                                            <input type="hidden" name="inventoryId" id="inventoryId">

                                             <div class="form-group">
                                                        <label for="inventoryName">Update Inventory Name</label>
                                                        <input type="text" class="form-control" id="updateInventoryName" name="inventoryName" aria-describedby="inventoryName" placeholder="Enter inventory name">
                                                      </div>
                                            <div class="form-group">
                                             <label for="quantity">Quantity</label>
                                              <input type="text" class="form-control" id="updateQuantity" name="quantity" aria-describedby="updateQuantity" placeholder="Update Quantity">
                                               </div>
                                               <div class="form-group">
                                                                            <label for="costPrice">Cost Price</label>
                                                                             <input type="text" class="form-control" id="updateCostPrice" name="costPrice" aria-describedby="costPrice" placeholder="Update Cost Price">
                                                                              </div>
                <div class="form-group">
                                                                            <label for="sellPrice">Sell Price</label>
                                                                             <input type="text" class="form-control" id="updateSellPrice" name="sellPrice" aria-describedby="sellPrice" placeholder="Update Sell Price">
                                                                              </div>

                                            <div class="form-group">
                                                <label for="image">Inventory Image</label>
                                                <div id="inventoryImageUpdate"></div>
                                                New Image <input type="file"  name="inventoryImage"  id="image">
                                            </div>
                                            <div class="form-check mb-3">
                                                                            <input type="checkbox" class="form-check-input" name="status" id="updateInventoryStatus" value="1">
                                                                            <label class="form-check-label" for="status">Show Inventory</label>
                                                                        </div>


                                            <button type="button" class="btn btn-secondary" id="updateInventoryClose" dadata-bs-dismiss="modal">Close</button>
                                            <button type="submit" name="updateInvent.ory" class="btn btn-primary">Submit</button>
                                        </form>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <script src="pagejs/product_drop_down_selected.js"></script>
                <script type="text/javascript" src="${pageContext.request.contextPath}/pagejs/update_inventory.js"></script>
                <script>
                    function confirmDeleteInventory(inventoryName) {
                     // alert("Are you sure you want to disable "+inventoryName);
                        let msg ="Are you sure you want to disable "+inventoryName;
                        if (confirm(msg)== true) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                </script>
                <script src="pagejs/product_drop_down.js"></script>
                </body>
                </html>