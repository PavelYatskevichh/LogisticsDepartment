<%@include file="../common/managerHeader.jsp"%>
        <div class="content">
            <table class="tbl">
                <tr>
                    <th>Full name</th>
                    <th>Phone number</th>
                    <th>Category</th>
                </tr>
                <c:forEach var="driver" items="${drivers}">
                    <tr>
                        <td>${driver.firstName} ${driver.lastName}</td>
                        <td>${driver.phoneNumber}</td>
                        <td>
                            <c:forEach var="category" items="${driver.categories}">
                                ${category.categoryName},
                            </c:forEach>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
<%@include file="../common/footer.jsp"%>