<%@include file="../common/customerHeader.jsp"%>
        <div class="content">

            <div class="title-container">
                <div id="special-title" class="title">Application ID: ${application.id}</div>
                <c:if test="${application.status.statusName == DELIVERED}">
                    <div class="delivered"><b>${application.status.statusName}</b></div>
                </c:if>
                <c:if test="${application.status.statusName != DELIVERED}">
                    <div class="status"><b>${application.status.statusName}</b></div>
                </c:if>
            </div>

            <div class="title">Application details:</div>

            <table>
                <tr><td>Items</td>
                    <td>
                        <table class="tbl">
                            <tr>
                                <c:forEach var="item" items="${application.items}">
                                    Name: ${item.name}
                                    <br>
                                    Dimensions: ${item.dimX} x ${item.dimY} x ${item.dimZ} mm
                                    <br>
                                    Weight: ${item.weight} kg
                                </c:forEach>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr><td>Load Address</td>
                    <td>${application.loadingAddress.city}, ${application.loadingAddress.street}, ${application.loadingAddress.building}</td>
                </tr>
                <tr><td>Upload Address</td>
                    <td>${application.unloadingAddress.city}, ${application.unloadingAddress.street}, ${application.unloadingAddress.building}</td>
                </tr>
            </table>
            <br>
            <button class="button" onclick="document.location='<c:url value="/customer/${customerId}/main"/>'">Back</button>
        </div>
<%@include file="../common/footer.jsp"%>