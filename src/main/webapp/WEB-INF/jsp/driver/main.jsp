<%@include file="../common/driverHeader.jsp"%>

        <title>Main page</title>
    </head>
    <body>
        <h2>Current route:<br></h2>

        <c:if test="${currentRoute.id != null}">
            <a href="<c:url value="/driver/${driverId}/route?id=${currentRoute.id}"/>">Route ID: ${currentRoute.id}</a>
        </c:if>

        <h2>Route history:<br></h2>

        <c:forEach var="completedRoute" items="${completedRoutes}">
            <a href="<c:url value="/driver/${driverId}/route?id=${completedRoute.id}"/>">Route ID: ${completedRoute.id}<br></a>
        </c:forEach>

    </body>
</html>