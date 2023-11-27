<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix ="c" uri="jakarta.tags.core" %>

<html>
    <head>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="../../resources/css/styles.css">
        <script src="../../resources/js/common.js"></script>

        <title>LogixDep</title>
    </head>
    <body>
    <div class="wrapper">
        <div class="header">
            <div>
                <a  href='<c:url value="/customer/${customerId}/main"/>'>Main</a>
            </div>
            <div>
                <a href='<c:url value="/customer/${customerId}/new"/>'>New application</a>
            </div>
            <div class="authorization">
                <a href='<c:url value="/customer/${customerId}/authorization"/>'>Authorization</a>
            </div>
        </div>

        <div class="gradient"></div>