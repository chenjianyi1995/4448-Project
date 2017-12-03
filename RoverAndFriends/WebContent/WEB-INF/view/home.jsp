<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>




<h3 align="center"> Welcome ${user.userName}</h3>

<div class="container">

	<table class="table table-striped">
		<thead>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Dog Sitter Status</th>
				<th>Zip Code</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${user.userName}</td>
				<td>${user.email}</td>
				<td>${user.dogSitter}</td>
				<td>${user.zipCode}</td>
				<td><a type="button" class="btn btn-primary"
					href="/RoverAndFriends/changeDogSittingStatusToTrue">True </a></td>
				<td><a type="button" class="btn btn-primary"
					href="/RoverAndFriends/changeDogSittingStatusToFalse">False </a></td>
			</tr>

		</tbody>
	</table>

</div>

<%@ include file="common/footer.jspf"%>