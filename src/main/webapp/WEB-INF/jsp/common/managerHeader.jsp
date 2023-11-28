<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix ="c" uri="jakarta.tags.core" %>
<%@ taglib prefix ="f" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="../../resources/css/styles.css">
        <script src="../../resources/js/manager.js"></script>
        <script src="../../resources/js/common.js"></script>

        <title>LogixDep</title>
    </head>
    <body>
    <div class="wrapper">
        <div class="header">
            <div>
                <a href='<c:url value="/manager/${managerId}/main"/>'>Main</a>
            </div>
            <div>
                <a href='<c:url value="/manager/${managerId}/unallocated"/>'>Unallocated</a>
            </div>
            <div>
                <a href='<c:url value="/manager/${managerId}/create"/>'>Create route</a>
            </div>
            <div>
                <a href='<c:url value="/manager/${managerId}/routes"/>'>Routes</a>
            </div>
            <div>
                <a href='<c:url value="/manager/${managerId}/drivers"/>'>Drivers</a>
            </div>
            <div>
                <a href='<c:url value="/manager/${managerId}/transport"/>'>Transport</a>
            </div>
            <div class="authorization">
                <a href='<c:url value="/manager/${managerId}/authorization"/>'>Authorization</a>
            </div>
        </div>

        <div class="gradient"></div>