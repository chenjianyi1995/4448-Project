<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
</div>

<h3 align="center"> Number of pet tags in your cart ${cart.item_number}</h3>

<div class="container">

	<table class="table table-striped">
		<thead>
			<tr>
				<th>Tag</th>
				<th>Price</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Limited Edition Rover Tag <img src="https://img.chewy.com/is/image/catalog/124628_MAIN._AC_SS190_V1495833078_.jpg" style="width:50; height:50; margin-left:20px"> </td>
				<td>$100</td>
				<td><a type="button" class="btn btn-primary"
					href="/RoverAndFriends/addPettag">Add pettag </a></td>
				<td><a type="button" class="btn btn-primary"
					href="/RoverAndFriends/deletePettag">Undo </a></td>
			</tr>

		</tbody>
	</table>
	<div>
		<h3>Total Price: $${100* cart.item_number}</h3>
	</div>
	<div>
		
		<button type="button" class="btn btn-primary">
			Purchase
		</button>
	</div>
</div>

<%@ include file="common/footer.jspf"%>
