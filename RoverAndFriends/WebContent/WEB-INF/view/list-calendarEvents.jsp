<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


	<div class="container">
		<table class="table table-striped">
			<caption>Your Calendar Events are</caption>
			<thead>
				<tr>
					<th>Description</th>
					<th>Date</th>
					<th>Completed</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${calendarEvents}" var="calendarEvent">
					<tr>
						<td>${calendarEvent.desc}</td>
						<td><fmt:formatDate pattern="dd/MM/yyyy"
								value="${calendarEvent.targetDate}" /></td>
						<td>${calendarEvent.done}</td>
						<td><a type="button" class="btn btn-primary"
							href="/RoverAndFriends/update-calendarEvent?id=${calendarEvent.id}">Edit</a> <a type="button"
							class="btn btn-warning" href="/RoverAndFriends/delete-calendarEvent?id=${calendarEvent.id}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a type="button" class="btn btn-success" href="/RoverAndFriends/add-calendarEvent">Add</a>
		</div>
	</div>

<%@ include file="common/footer.jspf"%>
