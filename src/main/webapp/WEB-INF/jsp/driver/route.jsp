<%@include file="../common/driverHeader.jsp"%>

        <title>Route details</title>
    </head>
    <body>

        <table>
            <td><h2>Route ID: ${route.id}</h2></td>
            <td>
                Manager: ${route.manager.firstName} ${route.manager.lastName}
                <a href="tel:${route.manager.phoneNumber}">${route.manager.phoneNumber}</a>
            </td>
        </table>

        <h4>Active applications:</h4>

        <table class="applications">
            <c:forEach var="aApp" items="${activeApplications}">
                <tr>
                    <td>
                        <b>ID ${aApp.id}<b>
                    </td>
                    <td>
                        <table>
                            <tr>
                                <td class="index">
                                    Items IDs:
                                </td>
                                <td class="holder">
                                    <c:forEach var="item" items="${aApp.items}">${item.id}, </c:forEach>
                                </td>
                            </tr>
                            <tr>
                                <td class="index">
                                    from
                                </td>
                                <td class="holder">
                                    ${aApp.loadingAddress.city}, ${aApp.loadingAddress.street}, ${aApp.loadingAddress.building}
                                </td>
                            </tr>
                            <tr>
                                <td class="index">
                                    to
                                </td>
                                <td class="holder">
                                    ${aApp.unloadingAddress.city}, ${aApp.unloadingAddress.street}, ${aApp.unloadingAddress.building}
                                </td>
                            </tr>
                            <tr>
                                <td class="index">
                                    Client:
                                </td>
                                <td class="holder">
                                    ${aApp.customer.firstName} ${aApp.customer.lastName}
                                    <a href="tel:${aApp.customer.phoneNumber}">${aApp.customer.phoneNumber}</a>
                                </td>
                            </tr>
                        </table>
                    </td>
                    <td>
                        <button class="status" onclick="req(${driverId}, ${route.id}, ${aApp.id}, this)">${aApp.status.statusName}</button>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <h4>Delivered applications:</h4>

        <table class="applications">
            <c:forEach var="dApp" items="${deliveredApplications}">
                <tr>
                    <td>
                        <b>ID ${dApp.id}<b>
                    </td>
                    <td>
                        <table>
                            <tr>
                                <td class="index">
                                    Items IDs:
                                </td>
                                <td class="holder">
                                    <c:forEach var="item" items="${dApp.items}">${item.id}, </c:forEach>
                                </td>
                            </tr>
                            <tr>
                                <td class="index">
                                    from
                                </td>
                                <td class="holder">
                                    ${dApp.loadingAddress.city}, ${dApp.loadingAddress.street}, ${dApp.loadingAddress.building}
                                </td>
                            </tr>
                            <tr>
                                <td class="index">
                                    to
                                </td>
                                <td class="holder">
                                    ${dApp.unloadingAddress.city}, ${dApp.unloadingAddress.street}, ${dApp.unloadingAddress.building}
                                </td>
                            </tr>
                            <tr>
                                <td class="index">
                                    Client:
                                </td>
                                <td class="holder">
                                    ${dApp.customer.firstName} ${dApp.customer.lastName}
                                    <a href="tel:${dApp.customer.phoneNumber}">${dApp.customer.phoneNumber}</a>
                                </td>
                            </tr>
                        </table>
                    </td>
                    <td>
                        <div class="delivered"><b>${dApp.status.statusName}</b></div>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <button class="button" onclick="document.location='<c:url value="/driver/${driverId}/main"/>'">Back</button>

    </body>
</html>