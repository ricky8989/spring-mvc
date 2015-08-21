<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student form</title>
</head>
<body>
	<h1>${headerMessage}</h1>
	<h3>Form Entry</h3>
	<p>
	<form:errors path="studentInfo.*" />
	</p>
	<form action="submitAdmissionForm.html"
		method="post">

		<table>
			<tr>
				<td>Student's Name :</td>
				<td><input type="text" name="studentName" /></td>
			</tr>
			<tr>
				<td>Student's Hobby :</td>
				<td><input type="text" name="studentHobby" /></td>
			</tr>

			<tr>
				<td>Student's Mobile :</td>
				<td><input type="text" value="123" name="studentMobile" /></td>
			</tr>
			<tr>
				<td>Student's DOB :</td>
				<td><input type="text" value="12/12/1966" name="studentDOB" /></td>
			</tr>
			<tr>
				<td>Student's Skills set :</td>
				<td><select name="studentSkills" multiple>
						<option value="Java Core">Java Core</option>
						<option value="Spring Core">Spring Core</option>
						<option value="Spring MVC">Spring MVC</option>
				</select>
				<td>
			</tr>


		</table>
		
		<table>
			<tr><td>Student's Address : </td></tr> 
		<tr>
			<td>street: <input type="text" name="studentAddress.street" /></td>
			<td>city: <input type="text" name="studentAddress.city" /></td>
			<td>zip code:<input type="text" value="123" name="studentAddress.zipCode" /></td>
			<td>country: <input type="text" name="studentAddress.country"/></td>
		</tr>
		
		<tr><td><input type="submit" value="Submit this form by clicking here" /></td></tr>
	</table>

	</form>



</body>
</html>