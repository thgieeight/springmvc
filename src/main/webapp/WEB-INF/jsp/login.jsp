<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<div class="container">
    <div class="row">
        <div class="col-md-4 mx-auto">
            <form class="form-signin" action="#" method="POST">
                <h1 class="h3 mb-3 font-weight-normal text-center"> Sign in</h1>

                <label for="username" class="sr-only">Username</label>
                <input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
                <div class="mb-3"></div>
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
                <div class="mb-3">
                    <a href="http://localhost:8080/invmgtsys/send-email">Forget Password</a>
                </div>
                <button name="login" class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                <div class="mb-3"> Does not have an account? <a href="register.php"> New Register</a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>