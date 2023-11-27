<%@include file="../common/managerHeader.jsp"%>
        <div class="content">
            <table class="tbl">
                <tr>
                    <th>Vehicle name</th>
                    <th>Required<br>category</th>
                    <th>Body dimensions,<br>mm</th>
                    <th>Load capacity,<br>kg</th>
                    <th>Trip distance,<br>km</th>
                </tr>
                <c:forEach var="vehicle" items="${vehicles}">
                    <tr>
                        <td>${vehicle.name}</td>
                        <td>${vehicle.requiredCategory.categoryName}</td>
                        <td>
                            ${vehicle.dimXRestrictions}(l) x ${vehicle.dimYRestrictions}(b) x ${vehicle.dimZRestrictions}(h)
                        </td>
                        <td>${vehicle.maxLoadCapacity}</td>
                        <td>${vehicle.maxTripDistance}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
<%@include file="../common/footer.jsp"%>