<%@include file="../common/customerHeader.jsp"%>
        <div class="content">
            <div class="title">Active applications:</div>

            <c:forEach var="aApp" items="${activeApplications}">
                <a class="item" href="<c:url value="/customer/${customerId}/application?id=${aApp.id}"/>">
                    ID: ${aApp.id} |
                    ${aApp.items.stream().findFirst().get().name}
                    to ${aApp.unloadingAddress.city}, ${aApp.unloadingAddress.street}, ${aApp.unloadingAddress.building} -
                </a>
                <div class="status"><b>${aApp.status.statusName}</b></div>
                <br>
            </c:forEach>

            <div class="title">Applications history:</div>

            <c:forEach var="dApp" items="${deliveredApplications}">
                <a class="item" href="<c:url value="/customer/${customerId}/application?id=${dApp.id}"/>">
                    ID: ${dApp.id} |
                    ${dApp.items.stream().findFirst().get().name}
                    to ${dApp.unloadingAddress.city}, ${dApp.unloadingAddress.street}, ${dApp.unloadingAddress.building} -
                </a>
                <div class="delivered"><b>${dApp.status.statusName}</b></div>
                <br>
            </c:forEach>
        </div>
<%@include file="../common/footer.jsp"%>