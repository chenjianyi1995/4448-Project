<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	Edit page to buy pet tags
</div>

<h3 align="center"> Number of pettags in your cart ${cart.item_number}</h3>

<div class="container">

	<table class="table table-striped">
		<thead>
			<tr>
				<th>Tag</th>
				
				<th></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${cart}</td>
				<td><a type="button" class="btn btn-primary"
					href="/RoverAndFriends/addPettag">Add pettag </a></td>
				<td><a type="button" class="btn btn-primary"
					href="/RoverAndFriends/deletePettag">Undo </a></td>
			</tr>

		</tbody>
	</table>

</div>

<%@ include file="common/footer.jspf"%>
