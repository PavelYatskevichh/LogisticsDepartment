<%@include file="../common/loginHeader.jsp"%>
        <div class="login-content">
            <div class="title">Please sign in:</div>

            <form action="<c:url value="/login"/>" method="post">
                <div style="color: red">
                    <c:if test="${error}">
                        Bad credentials
                    </c:if>
                </div>

                <table style="margin: auto">
                    <tr>
                        <td><label class="label"> Email: </label></td>
                        <td><input class="input" type="text" name="username"></td>
                    </tr>
                    <tr>
                        <td><label class="label"> Password: </label></td>
                        <td><input class="input" type="password" name="password"></td>
                    </tr>
                </table>

                <input type="submit" class="button" value="Login">
            </form>
        </div>
<%@include file="../common/footer.jsp"%>