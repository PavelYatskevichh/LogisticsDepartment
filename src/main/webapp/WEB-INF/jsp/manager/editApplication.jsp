<%@include file="../common/managerHeader.jsp"%>
        <div class="content">
            <div class="title-container">
                <div id="special-title" class="title">Application ID: ${application.id}</div>
                <div>
                    Client: ${application.customer.firstName} ${application.customer.lastName}
                    <a href="tel:${application.customer.phoneNumber}">${application.customer.phoneNumber}</a>
                </div>
            </div>

            <form action="<c:url value="/manager/${managerId}/editApplication?applicationId=${application.id}"/>" method="post">

                <div class="title">Item details:</div>

                <table>
                    <tr>
                        <td><label class="label"> Item name: </label></td>
                        <td><input class="input" name="name" value="${application.items.stream().findFirst().get().name}"></td>
                    </tr>
                    <tr>
                        <td><label class="label"> Length: </label></td>
                        <td><input class="input" name="dimX" value="${application.items.stream().findFirst().get().dimX}"> mm</td>
                    </tr>
                    <tr>
                        <td><label class="label"> Width: </label></td>
                        <td><input class="input" name="dimY" value="${application.items.stream().findFirst().get().dimY}"> mm</td>
                    </tr>
                    <tr>
                        <td><label class="label"> Height: </label></td>
                        <td><input class="input" name="dimZ" value="${application.items.stream().findFirst().get().dimZ}"> mm</td>
                    </tr>
                    <tr>
                        <td><label class="label"> Weight: </label></td>
                        <td><input class="input" name="weight" value="${application.items.stream().findFirst().get().weight}"> kg</td>
                    </tr>
                </table>

                <div class="title">Loading address:</div>

                <table>
                    <tr>
                        <td><label class="label"> City: </label></td>
                        <td><input class="input" name="loadCity" value="${application.loadingAddress.city}"></td>
                    </tr>
                    <tr>
                        <td><label class="label"> Street: </label></td>
                        <td><input class="input" name="loadStreet" value="${application.loadingAddress.street}"></td>
                    </tr>
                    <tr>
                        <td><label class="label"> Building: </label></td>
                        <td><input class="input" name="loadBuilding" value="${application.loadingAddress.building}"></td>
                    </tr>
                </table>

                <div class="title">Unloading address:</div>

                <table>
                    <tr>
                        <td><label class="label"> City: </label></td>
                        <td><input class="input" name="unloadCity" value="${application.unloadingAddress.city}"></td>
                    </tr>
                    <tr>
                        <td><label class="label"> Street: </label></td>
                        <td><input class="input" name="unloadStreet" value="${application.unloadingAddress.street}"></td>
                    </tr>
                    <tr>
                        <td><label class="label"> Building: </label></td>
                        <td><input class="input" name="unloadBuilding" value="${application.unloadingAddress.building}"></td>
                    </tr>
                </table>

                <br>
                <input type="submit" class="button" value="Edit">
                <input type="button" class="button"
                onclick="document.location='<c:url value="/manager/${managerId}/unallocated"/>'" value="Back">

            </form>
        </div>
<%@include file="../common/footer.jsp"%>