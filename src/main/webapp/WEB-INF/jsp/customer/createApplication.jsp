<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix ="c" uri="jakarta.tags.core" %>

<html>
    <head>
        <title>Create application</title>
    </head>
    <body>
        <form action="<c:url value="/customer/createApplication"/>">
            Item 1 details:
            <table class="create_application">
                <tr><td><label> Length: </label></td><td><input name="dimX">mm</td></tr>
                <tr><td><label> Width: </label></td><td><input name="dimY">mm</td></tr>
                <tr><td><label> Height: </label></td><td><input name="dimZ">mm</td></tr>
                <tr><td><label> Weight: </label></td><td><input name="weight">kg</td></tr>
                <tr><td></td><td><button>+ Another item</button></td></tr>
            </table>
            Loading address:
            <table class="create_application">
                <tr><td><label> City: </label></td><td><input name="loadCity"></td></tr>
                <tr><td><label> Street: </label></td><td><input name="loadStreet"></td></tr>
                <tr><td><label> Building: </label></td><td><input name="loadBuilding"></td></tr>
            </table>
            Unloading address:
            <table class="create_application">
                <tr><td><label> City: </label></td><td><input name="unloadCity"></td></tr>
                <tr><td><label> Street: </label></td><td><input name="unloadStreet"></td></tr>
                <tr><td><label> Building: </label></td><td><input name="unloadBuilding"></td></tr>
            </table>
            <input type="submit" value="Create application">
            <input type="submit" value="Clear">
            <input type="submit" value="Cancel">
        </form>
    </body>
</html>