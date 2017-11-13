<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


	<div class="container">
		<table class="table table-striped">
			<caption>${user.userName}</caption>
			<thead>
				<tr>
					<th>Friends List</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${friendsList}" var="friends">
					<tr>
						<td>${friends.friendName}</td>
						<td><a type="button"
							class="btn btn-danger" href="/RoverAndFriends/delete-friends?id=${friends.id}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a type="button" class="btn btn-success" href="/RoverAndFriends/addFriends">Add</a>
		</div>
	</div>

<%@ include file="common/footer.jspf"%>
