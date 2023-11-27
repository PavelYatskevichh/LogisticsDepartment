<%@include file="../common/managerHeader.jsp"%>
        <div class="content">
            <div class="title">Unallocated applications:</div>

            <table class="tbl">
                <c:forEach var="uApp" items="${unallocatedApplications}">
                    <tr>
                        <td>
                            <b>ID ${uApp.id}</b>
                        </td>
                        <td>
                            <table class="tbl-details">
                                <tr>
                                    <td class="prop">
                                        Items:
                                    </td>
                                    <td class="holder">
                                        <c:forEach var="item" items="${uApp.items}">
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
                                        ${uApp.loadingAddress.city}, ${uApp.loadingAddress.street}, ${uApp.loadingAddress.building}
                                    </td>
                                </tr>
                                <tr>
                                    <td class="prop">
                                        to
                                    </td>
                                    <td class="holder">
                                        ${uApp.unloadingAddress.city}, ${uApp.unloadingAddress.street}, ${uApp.unloadingAddress.building}
                                    </td>
                                </tr>
                                <tr>
                                    <td class="prop">
                                        Client:
                                    </td>
                                    <td class="holder">
                                        ${uApp.customer.firstName} ${uApp.customer.lastName}
                                        <a href="tel:${dApp.customer.phoneNumber}">${uApp.customer.phoneNumber}</a>
                                    </td>
                                </tr>
                            </table>
                        </td>
                        <td>
                            <div class="status"><b>${uApp.status.statusName}</b></div>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
<%@include file="../common/footer.jsp"%>