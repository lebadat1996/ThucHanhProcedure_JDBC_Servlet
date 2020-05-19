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
        <nav class="navbar navbar-light bg-light">
            <form class="form-inline" method="post" action="/Customers">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" name="name" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" name="action" value="search" type="submit">Search</button>
            </form>
        </nav>
        <div class="container text-left">
            <a href="/Customers?action=create" class="btn btn-success">Add New User</a>
        </div>
        <br>
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
            <c:forEach var="customer" items="${customerList}">
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
    </div>
</div>
</body>
</html>