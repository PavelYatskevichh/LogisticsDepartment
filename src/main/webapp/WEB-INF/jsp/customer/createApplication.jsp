<%@include file="../common/customerHeader.jsp"%>
        <div id="content" class="content">

            <c:url value="/customer/${customerId}/createApplication" var="createApplicationUrl" />

            <f:form id="itemForm1" method="post" action="${createApplicationUrl}" modelAttribute="createItem">
                <table>
                    <div class="title-container">
                        <div class="title">Item details:</div>
                        <div><input type="button" class="statusbtn deletebtn" value="Delete item"></div>
                    </div>

                    <tr>
                        <td><f:label class="label" path="name"> Item name: </f:label></td>
                        <td><f:input class="input" path="name"></f:input></td>
                    </tr>
                    <tr>
                        <td><f:label class="label" path="dimX"> Length: </f:label></td>
                        <td><f:input class="input" path="dimX"></f:input> mm</td>
                    </tr>
                    <tr>
                        <td><f:label class="label" path="dimY"> Width: </f:label></td>
                        <td><f:input class="input" path="dimY"></f:input> mm</td>
                    </tr>
                    <tr>
                        <td><f:label class="label" path="dimZ"> Height: </f:label></td>
                        <td><f:input class="input" path="dimZ"></f:input> mm</td>
                    </tr>
                    <tr>
                        <td><f:label class="label" path="weight"> Weight: </f:label></td>
                        <td><f:input class="input" path="weight"></f:input> kg</td>
                    </tr>
                </table>
            </f:form>

            <input id="addItem" type="button" class="statusbtn" value="Add another item">

            <f:form id="loadAdrForm" method="post" action="${createApplicationUrl}" modelAttribute="createLoadAddress">
                <table>
                    <div class="title">Loading address:</div>
                    <tr>
                        <td><f:label class="label" path="city"> City: </f:label></td>
                        <td><f:input class="input" path="city"></f:input></td>
                    </tr>
                    <tr>
                        <td><f:label class="label" path="street"> Street: </f:label></td>
                        <td><f:input class="input" path="street"></f:input></td>
                    </tr>
                    <tr>
                        <td><f:label class="label" path="building"> Building: </f:label></td>
                        <td><f:input class="input" path="building"></f:input></td>
                    </tr>
                </table>
            </f:form>

            <f:form id="unloadAdrForm" method="post" action="${createApplicationUrl}" modelAttribute="createUnloadAddress">
                <table>
                    <div class="title">Unloading address:</div>
                    <tr>
                        <td><f:label class="label" path="city"> City: </f:label></td>
                        <td><f:input class="input" path="city"></f:input></td>
                    </tr>
                    <tr>
                        <td><f:label class="label" path="street"> Street: </f:label></td>
                        <td><f:input class="input" path="street"></f:input></td>
                    </tr>
                    <tr>
                        <td><f:label class="label" path="building"> Building: </f:label></td>
                        <td><f:input class="input" path="building"></f:input></td>
                    </tr>
                </table>
            </f:form>

            <input type="submit" class="button" value="Create">
            <input type="reset" class="button" value="Reset">
            <input type="button" class="button" onclick="document.location='<c:url value="/customer/${customerId}/main"/>'" value="Back">

        </div>
<%@include file="../common/footer.jsp"%>