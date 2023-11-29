<%@include file="../common/managerHeader.jsp"%>
        <div class="content">

            <div class="title">Unallocated applications in total: ${numberOfUnallocated}</div>

            <div class="title">Active routes:</div>

            <table class="tbl">
                <c:forEach var="aRoute" items="${activeRoutes}">

                    <tr>
                        <td>
                            <b>ID ${aRoute.id}</b>
                            <br>
                            Driver: ${aRoute.driver.firstName} ${aRoute.driver.lastName}
                        </td>
                        <td>
                            <table class="tbl-details">
                                <c:forEach var="application" items="${aRoute.applications}">
                                    <tr><td>
                                        ID: ${application.id} |
                                        ${application.items.stream().findFirst().get().name}
                                        to ${application.unloadingAddress.city}, ${application.unloadingAddress.street}, ${application.unloadingAddress.building} -
                                        <c:if test="${application.status.statusName == DELIVERED}">
                                            <div class="delivered"><b>${application.status.statusName}</b></div>
                                        </c:if>
                                        <c:if test="${application.status.statusName != DELIVERED}">
                                            <div class="status"><b>${application.status.statusName}</b></div>
                                        </c:if>
                                    </td></tr>
                                </c:forEach>
                            </table>
                        </td>
                    </tr>

                </c:forEach>
            </table>
        </div>
<%@include file="../common/footer.jsp"%>