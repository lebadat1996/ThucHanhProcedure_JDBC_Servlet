<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous">
<html>
<head>
    <title>CustomerUses</title>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: black">
        <h2>
            <a href="/Customers?action=Customers">List All Customer</a>
        </h2>
    </nav>
</header>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <form method="post">
                <caption>
                    <h2>Add Customer</h2>
                </caption>

                <div class="form-group">
                    <label>Name</label>
                    <input type="text" value="" class="form-control" name="name">
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" value="" class="form-control" name="pass">
                </div>

                <div class="form-group">
                    <label>Phone</label>
                    <input type="text" value="" class="form-control" name="phone">
                </div>

                <div class="form-group">
                    <label>Email</label>
                    <input type="text" value="" class="form-control" name="email">
                </div>

                <div class="form-group">
                    <label>Address</label>
                    <input type="text" value="" class="form-control" name="address">
                </div>

                <button type="submit" class="btn btn-success">Save</button>
            </form>

        </div>
    </div>
</div>
</body>
</html>
