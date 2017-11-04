<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h3>List of Users</h3></caption>
            <tr>
                <th>Name</th>
                <th>Email</th>
            </tr>
            <c:forEach var="user" items="${userList}">
                <tr>
                    <td><c:out value="${user.userName}" /></td>       
                    <td><c:out value="${user.email}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>	

<%@ include file="common/footer.jspf"%>