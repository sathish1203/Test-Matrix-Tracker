
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file = "header_admin.jsp"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<!-- ****************Start of the container**********************-->

<div class="container">
<div class="row">


<!-- ****************Start of the form**********************-->
<div class="col-md-12">
	<h2>Add Device Data</h2>
	<form:form method="POST" action="/Trane_TestCase_Repository/admin_save_device">
<table>
<tr>
	<td><form:label path="id">Device ID:</form:label></td>
<td><c:out value="${device.id}" /></td>
<td><form:errors path="id" style="color:red"/><form:hidden path="id" value="${device.id}"/></td>
</tr>
<tr>
<td><form:label path="name">Device Name:</form:label></td>
<td><form:input path="name" value="${device.name}" /></td>
<td><form:errors path="name" style="color:red"/></td>
</tr>
<tr>
	<td><form:label path="description">Device Description:</form:label></td>
<td><form:input path="description" value="${device.description}" /></td>
<td><form:errors path="description" style="color:red"/></td>
</tr>
<tr>
	<td colspan="2"><input type="submit" value="Submit" /></td>
</tr>
</table>
</form:form>
</div>
<!-- ****************End of the form**********************-->
     
     
</div>
<hr />
<div class="row">


	  <!-- ****************Start of the Table to list**********************-->
<div class="col-sm-12">
	<c:if test="${!empty devices}">
<h2>List Devices</h2>
<table class = "table">
<tr>
  	<th>Device ID</th>
	<th>Device Name</th>
	<th>Device Description</th>
	<th>Action</th>
</tr>
<c:forEach items="${devices}" var="device">
<tr>
	<td><c:out value="${device.id}" /></td>
<td><c:out value="${device.name}" /></td>
<td><c:out value="${device.description}" /></td>
<td align="center"><a href="/Trane_TestCase_Repository/admin_edit_device?id=${device.id}">Edit</a>
| <a href="/Trane_TestCase_Repository/admin_delete_device?id=${device.id}">Delete</a></td>
</tr>
</c:forEach>
</table>
</c:if>
</div>
  <!-- ****************End of the table to list**********************-->
	  
	  
</div>
</div>
  <!-- ****************End of the container**********************-->
<hr />

 
</body>
</html>
<%@include file = "footer.jsp"  %>