<%@include file="../common/managerHeader.jsp"%>
        <div class="content">
            <div class="title">Active routes:</div>

            <c:forEach var="activeRoute" items="${activeRoutes}">
                <a class="item" href="<c:url value="/manager/${managerId}/route?id=${activeRoute.id}"/>">
                    Route ID: ${activeRoute.id} | Manager: ${activeRoute.manager.firstName} ${activeRoute.manager.lastName}
                </a>
                <br>
            </c:forEach>

            <div class="title">Route history:</div>

            <c:forEach var="completedRoute" items="${completedRoutes}">
                <a class="item" href="<c:url value="/manager/${managerId}/route?id=${completedRoute.id}"/>">
                    Route ID: ${completedRoute.id} | Manager: ${completedRoute.manager.firstName} ${completedRoute.manager.lastName}
                </a>
                <br>
            </c:forEach>
        </div>
<%@include file="../common/footer.jsp"%>