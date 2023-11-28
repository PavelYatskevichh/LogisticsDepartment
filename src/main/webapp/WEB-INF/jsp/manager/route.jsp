<%@include file="../common/managerHeader.jsp"%>
        <div class="content">
            <div class="title-container">
                <div id="special-title" class="title">Route ID: ${route.id}</div>
                <div>
                    Manager: ${route.manager.firstName} ${route.manager.lastName}
                    <a href="tel:${route.manager.phoneNumber}">${route.manager.phoneNumber}</a>
                </div>
            </div>

            <div class="title-container">
                <div class="title">Driver: </div>
                <div>
                    ${route.driver.firstName} ${route.driver.lastName}
                    <a href="tel:${route.driver.phoneNumber}">${route.driver.phoneNumber}</a>
                </div>
            </div>

            <div class="title-container">
                <div class="title">Transport: </div>
                <div>
                    ${route.vehicle.name}
                </div>
            </div>

            <div class="title">Active applications:</div>

            <table class="tbl">
                <c:forEach var="aApp" items="${activeApplications}">
                    <tr>
                        <td>
                            <b>ID ${aApp.id}</b>
                        </td>
                        <td>
                            <table class="tbl-details">
                                <tr>
                                    <td class="prop">
                                        Items:
                                    </td>
                                    <td class="holder">
                                        <c:forEach var="item" items="${aApp.items}">
                                            ID ${item.id} | ${item.dimX} x ${item.dimX} x ${item.dimX} mm | ${item.weight} kg
                                            <br>
                                        </c:forEach>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="prop">
                                        from
                                    </td>
                                    <td class="holder">
                                        ${aApp.loadingAddress.city}, ${aApp.loadingAddress.street}, ${aApp.loadingAddress.building}
                                    </td>
                                </tr>
                                <tr>
                                    <td class="prop">
                                        to
                                    </td>
                                    <td class="holder">
                                        ${aApp.unloadingAddress.city}, ${aApp.unloadingAddress.street}, ${aApp.unloadingAddress.building}
                                    </td>
                                </tr>
                                <tr>
                                    <td class="prop">
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
                            <div class="status"><b>${aApp.status.statusName}</b></div>
                        </td>
                    </tr>
                </c:forEach>
            </table>

            <div class="title">Delivered applications:</div>

            <table class="tbl">
                <c:forEach var="dApp" items="${deliveredApplications}">
                    <tr>
                        <td>
                            <b>ID ${dApp.id}</b>
                        </td>
                        <td>
                            <table class="tbl-details">
                                <tr>
                                    <td class="prop">
                                        Items IDs:
                                    </td>
                                    <td class="holder">
                                        <c:forEach var="item" items="${dApp.items}">${item.id}, </c:forEach>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="prop">
                                        from
                                    </td>
                                    <td class="holder">
                                        ${dApp.loadingAddress.city}, ${dApp.loadingAddress.street}, ${dApp.loadingAddress.building}
                                    </td>
                                </tr>
                                <tr>
                                    <td class="prop">
                                        to
                                    </td>
                                    <td class="holder">
                                        ${dApp.unloadingAddress.city}, ${dApp.unloadingAddress.street}, ${dApp.unloadingAddress.building}
                                    </td>
                                </tr>
                                <tr>
                                    <td class="prop">
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
            <button class="button" onclick="document.location='<c:url value="/manager/${managerId}/routes"/>'">Back</button>
        </div>
        <br>
<%@include file="../common/footer.jsp"%>