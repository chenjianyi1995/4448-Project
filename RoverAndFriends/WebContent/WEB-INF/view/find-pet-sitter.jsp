<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="container">

	<table class="table table-striped">
		<caption>List of dog sitters <br> Use email to get a hold of dog sitters</caption>
		<thead>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td><c:out value="${user.userName}" /></td>
					<td><c:out value="${user.email}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>


<%@ include file="common/footer.jspf"%>