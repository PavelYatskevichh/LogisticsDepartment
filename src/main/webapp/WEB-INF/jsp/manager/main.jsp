<%@include file="../common/managerHeader.jsp"%>
        <div class="content">
            <div class="title">Active routes:</div>

            <table class="tbl">
                <c:forEach var="aRoute" items="${activeRoutes}">

                    <tr data-href="<c:url value="/manager/${managerId}/route?id=${aRoute.id}"/>">
                        <td>
                            <b>ID ${aRoute.id}</b>
                            <br>
                            Driver: ${aRoute.driver.firstName} ${aRoute.driver.lastName}
                        </td>
                        <td>
                            <table class="tbl-details">
                                <c:forEach var="aApp" items="${aRoute.applications}">
                                    <tr><td>
                                        ID: ${aApp.id} |
                                        ${aApp.items.stream().findFirst().get().name}
                                        to ${aApp.unloadingAddress.city}, ${aApp.unloadingAddress.street}, ${aApp.unloadingAddress.building} -
                                        <div class="status"><b>${aApp.status.statusName}</b></div>
                                    </td></tr>
                                </c:forEach>
                            </table>
                        </td>
                    </tr>

                </c:forEach>
            </table>
        </div>
<%@include file="../common/footer.jsp"%>