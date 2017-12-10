<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="container">

	<table class="table table-striped">
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
					<td><a type="button" class="btn btn-primary"
						href="/RoverAndFriends/add-friends?friendnamename=${user.userName}">Add
							Friend</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>


<%@ include file="common/footer.jspf"%>