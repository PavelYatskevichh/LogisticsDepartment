<%@include file="../common/managerHeader.jsp"%>
        <div class="login-content">
            <div class="title" style="font-size: 30px">Hi ${user.firstName} ${user.lastName}!</div>
            <form action="<c:url value="/logout"/>" method="post">
                <input type="submit" class="button" value="Log out">
            </form>
        </div>
<%@include file="../common/footer.jsp"%>