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
          <a class="nav-link active" href="http://localhost:8080/invmgtsys/product">Product</a>
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
          <a class="nav-link" href="http://localhost:8080/invmgtsys/report">Report</a>
        </li>
      </ul>
    </nav>
<br>
&nbsp;&nbsp;
    <button type="button" onclick="getCategoryDropDown()" class="btn btn-primary" data-toggle="modal" data-target="#add-product-model">
        Add product
    </button>




<div class="container"  style="min-height:675px;">
<div class="row">
<table class="table">
    <tr>
        <th>Id</th>
        <th>Category</th>
        <th>Product Name</th>
        <th>Added Date</th>
        <th>Image</th>
        <th>Status</th>
        <th>Action</th>
        <th>Action</th>
    </tr>
    <c:forEach var="product" items="${productList}">
      <tr>
        <td>${product.productId}</td>
           <td>${product.category.categoryName}</td>
          <td>${product.productName}</td>
          <td>${product.addedDate}</td>
          <td><img src="${request.contextPath}/invmgtsys/uploads/${product.image}" height="50px" width="50px"></td>
<%--          <td><img src="/var/tmp/myuploads/0381_6Jan2023131040GMT_1673010640931.png"></td>--%>
<%--          <td><img src="<c:url value="/resources/static/images/${product.image}" />" alt="" /></td>--%>
<%--          <td><img alt="image"  src="<c:url value="images/${product.image}" />"></td>--%>
<%--          <td><img src="/images/${product.image}" height="100px" width="100px"></td>--%>
<%--          <td><%= {product.status}=="1"?"Enabled":"Disabled" %>}</td>--%>
          <td>${product.status==1 ? 'Enabled' : 'Disabled'}
          </td>
          <td><button onclick="updateProduct('${product.productId}')" class="btn btn-primary">Edit</button> </td>
           <td>   <form action="/invmgtsys/delete-product" onsubmit="return confirmDeleteProduct('${product.productName}')" method="POST" >
                  <input type="hidden" name="productId" value="${product.productId}">
                  <button type="submit" onclick="deleteProduct();" class="btn btn-primary">Delete</button>
              </form>
          </td>
        </tr>
    </c:forEach>
</table>
</div>
</div>






<div class="modal fade" id="add-product-model" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Enter Product Details</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-12 mx-auto">
                        <form action="/invmgtsys/add-product" method="POST" enctype="multipart/form-data">


                            <div class="form-group">
                                <label for="productName">Product Name</label>
                                <input type="text" class="form-control" id="productName" name="productName" aria-describedby="productName" placeholder="Enter product name">
                            </div>

                            <div class="form-group">
                                <label for="productImage">Product Image</label>
                                <input type="file" class="form-control" id="productImage" name="productImage">
                            </div>

                             <div class="form-group">
                                <label for="productImage">Select Category</label>
                                <select class="form-control form-select" id="categoryId" name="categoryId" aria-label="Default select example">
                                <option selected>Select Category</option>
                                </select>
                             </div>

                            <div class="form-check mb-3">
                                <input type="checkbox" class="form-check-input" name="status" id="status" value="1">
                                <label class="form-check-label">Show Product</label>
                            </div>

                            <button type="button" class="btn btn-secondary" id="addCloseBtn" data-dismiss="modal">Close</button>
                            <button type="submit" name="addProduct" class="btn btn-primary">Submit</button>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

<!-- update product model start -->
<div class="modal fade" id="updateProduct" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" >Update product detail</h5>

            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-12 mx-auto">
                        <form action="/invmgtsys/update-product" method="POST" enctype="multipart/form-data" >
                            <input type="hidden" name="productId" id="productId">

                            <div class="form-group">
                                <label for="productName">Product Name</label>
                                <input type="text" class="form-control" id="productName" name="productName" aria-describedby="productName" placeholder="Enter product name">
                            </div>



                            <div class="form-check mb-3">
                                <input type="checkbox" class="form-check-input" name="status" id="productStatus" value="1">
                                <label class="form-check-label" for="status">Show Product</label>
                            </div>

                            <div class="form-group">
                                                            <label for="productImage">Select Category</label>
                                                            <select class="form-control form-select" id="updateCategoryId" name="categoryId" aria-label="Default select example">
                                                                <option selected>Select Category</option>
                                                            </select>
                                                        </div>

                            <div class="form-group">
                                <label for="image">Product Image</label>
                                <div id="productImageUpdate"></div>
                                Update Image <input type="file"  name="productImage"  id="image">
                            </div>


                            <button type="button" class="btn btn-secondary" id="updateProductClose" data-bs-dismiss="modal">Close</button>
                            <button type="submit" name="updateProduct" class="btn btn-primary">Submit</button>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<script src="pagejs/category_drop_down.js"></script>
<script src="pagejs/category_drop_down_selected.js"></script>
<script src="pagejs/update_product.js"></script>


<script>
    function confirmDeleteProduct(productName) {
     // alert("Are you sure you want to disable "+productName);
        let msg ="Are you sure you want to disable "+productName;
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