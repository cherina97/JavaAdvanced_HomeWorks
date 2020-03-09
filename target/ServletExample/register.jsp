<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Registration</title>
</head>
<body>
<h1> Create new user </h1>

<form action="register" method="post">

    <label for="firstName">First Name :</label> <input name="firstName" type="text">
    <br>
    <label for="lastName">Last Name :</label> <input name="lastName" type="text">
    <br>
    <label for="email">Email :</label> <input name="email" type="email">
    <br>
    <label for="password">Password : </label> <input name="password" type="password">
    <br>
    <input type="submit" value="Sign Up">
</form>
</body>
</html>