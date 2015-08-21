<html>
<body>
	<h1>${headerMessage}</h1>
 
	<h3>Congratulations, your application form has successfully been processed.</h3>

	<h2>Details you submitted are: </h2>

	<table>
		<tr>
			<td>Student Name :</td>
			<td>${studentInfo.studentName}</td>
		</tr>
		<tr>
			<td>Student Hobby :</td>
			<td>${studentInfo.studentHobby}</td>
		</tr>
		<tr>
			<td>Student Mobile :</td>
			<td>${studentInfo.studentMobile}</td>
		</tr>

		<tr>
			<td>Student DOB :</td>
			<td>${studentInfo.studentDOB}</td>
		</tr>
		<tr>
			<td>Student Skills :</td>
			<td>${studentInfo.studentSkills}</td>
		</tr>
		<tr>
			<td>Student Address :</td>
			<td>country: ${studentInfo.studentAddress.country}
			       city: ${studentInfo.studentAddress.city}
			     street: ${studentInfo.studentAddress.street}
			    zipcode: ${studentInfo.studentAddress.zipCode}</td>
		</tr>

	</table>

</body>
</html>
