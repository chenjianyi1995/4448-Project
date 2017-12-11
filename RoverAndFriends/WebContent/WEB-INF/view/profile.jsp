<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>


	<div class="container">
		<img src="http://www.cdn.innesvienna.net//Content/user-default.png" style="height:300; width:300; border:groove" >
		<div style="display:inline; margin-left:100px">
			<img src="https://cdn.pixabay.com/photo/2017/03/25/14/26/animals-2173635_1280.jpg" style="height:300; width:300; border:groove">
		</div>
		<div>
			<button type="button" class="btn btn-primary" style="margin-top:10px">Upload Image</button>
			<button type="button" class="btn btn-primary" style="margin-top:10px; margin-left:290px">Upload Image</button>
		</div>
		<div style="margin-top:15px">
			<form:form action="/RoverAndFriends/profile" method="post"
		modelAttribute="user">
				<textarea style="height:200px; width:700px" placeholder="Tell us about you and your pet!"></textarea>
				<!--  form:input path ="info" /-->
			</form:form>
		</div>
		<div>
			<button type="button" class="btn btn-primary">Submit</button>
		</div>
	</div>
	
	

<%@ include file="common/footer.jspf"%>