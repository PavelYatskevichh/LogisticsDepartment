<%@include file="../common/driverHeader.jsp"%>
        <div class="content">
            <div class="title">Current route:</div>

            <c:if test="${currentRoute.id != null}">
                <a class="item" href="<c:url value="/driver/${driverId}/route?id=${currentRoute.id}"/>">Route ID: ${currentRoute.id}</a>
            </c:if>

            <div class="title">Route history:</div>

            <c:forEach var="completedRoute" items="${completedRoutes}">
                <a class="item" href="<c:url value="/driver/${driverId}/route?id=${completedRoute.id}"/>">Route ID: ${completedRoute.id}<br></a>
            </c:forEach>
        </div>
<%@include file="../common/footer.jsp"%>