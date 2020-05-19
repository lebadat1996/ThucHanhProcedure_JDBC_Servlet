<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Management Application</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>

<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color:cadetblue">
        <div class="container">
            <h2 class="text-center">Admin Manager</h2>
        </div>
    </nav>
</header>
<br>
<div class="row">
    <div class="container">
        <div class="container text-left">
            <a href="/Customers?action=create" class="btn btn-success">Add New User</a>
        </div>
        <br>
        <form class="form-inline" method="post">
        <table class="table table-success table-hover">
            <thead>
            <tr>
                <th>Name</th>
                <th>Password</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Address</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="customer" items="${customers}">
                <tr>
                    <td><c:out value="${customer.getCustomerName()}"/></td>
                    <td><c:out value="${customer.getCustomerPass()}"/></td>
                    <td><c:out value="${customer.getPhone()}"/></td>
                    <td><c:out value="${customer.getEmail()}"/></td>
                    <td><c:out value="${customer.getAddress()}"/></td>
                    <td>
                        <a href="/Customers?action=edit&name=${customer.customerName}"> Edit</a>
                        <br>
                        <a href="/Customers?action=delete&name=${customer.customerName}"> Delete </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </form>
    </div>
</div>

</body>
</html>