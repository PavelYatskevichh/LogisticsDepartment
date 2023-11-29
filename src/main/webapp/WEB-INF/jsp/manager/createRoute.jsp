<%@include file="../common/managerHeader.jsp"%>
        <div class="content">

            <div class="title">Applications IDs:</div>

            <button class="statusbtn" onclick="add()">Add application Id</button>
            <button class="statusbtn deletebtn" onclick="remove()">Remove</button>

            <form action="<c:url value="/manager/${managerId}/createRoute"/>" method="post">
                <div id="appForm">
                    <input class="input" name="applicationId">
                </div>

                <div class="title">Route details:</div>

                <table>
                    <tr>
                        <td><label class="label"> Driver: </label></td>
                        <td><input class="input" name="driverId"></td>
                    </tr>
                    <tr>
                        <td><label class="label"> Transport: </label></td>
                        <td><input class="input" name="vehicleId"></td>
                    </tr>
                </table>

                <br>
                <input type="submit" class="button" value="Create">
                <input type="reset" class="button" value="Clear">
                <input type="button" class="button"
                onclick="document.location='<c:url value="/manager/${managerId}/main"/>'" value="Back">
            </form>
        </div>
        <br>
<%@include file="../common/footer.jsp"%>