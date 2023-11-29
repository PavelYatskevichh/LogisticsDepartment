<%@include file="../common/customerHeader.jsp"%>
        <div class="content">
            <form action="<c:url value="/customer/${customerId}/createApplication"/>" method="post">

                <div class="title">Item details:</div>

                <table>
                    <tr><td><label class="label"> Item name: </label></td><td><input class="input" name="name"></td></tr>
                    <tr><td><label class="label"> Length: </label></td><td><input class="input" name="dimX"> mm</td></tr>
                    <tr><td><label class="label"> Width: </label></td><td><input class="input" name="dimY"> mm</td></tr>
                    <tr><td><label class="label"> Height: </label></td><td><input class="input" name="dimZ"> mm</td></tr>
                    <tr><td><label class="label"> Weight: </label></td><td><input class="input" name="weight"> kg</td></tr>
                </table>

                <div class="title">Loading address:</div>

                <table>
                    <tr><td><label class="label"> City: </label></td><td><input class="input" name="loadCity"></td></tr>
                    <tr><td><label class="label"> Street: </label></td><td><input class="input" name="loadStreet"></td></tr>
                    <tr><td><label class="label"> Building: </label></td><td><input class="input" name="loadBuilding"></td></tr>
                </table>

                <div class="title">Unloading address:</div>

                <table>
                    <tr><td><label class="label"> City: </label></td><td><input class="input" name="unloadCity"></td></tr>
                    <tr><td><label class="label"> Street: </label></td><td><input class="input" name="unloadStreet"></td></tr>
                    <tr><td><label class="label"> Building: </label></td><td><input class="input" name="unloadBuilding"></td></tr>
                </table>

                <br>
                <input type="submit" class="button" value="Create">
                <input type="reset" class="button" value="Clear">
                <input type="button" class="button" onclick="document.location='<c:url value="/customer/${customerId}/main"/>'" value="Back">

            </form>
        </div>
<%@include file="../common/footer.jsp"%>