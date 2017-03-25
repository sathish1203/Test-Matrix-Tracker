<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file = "header_admin.jsp"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>




<!-- The body tag. This tag starts with the welcome message.-->
<body>


<!-- ****************Start of the container**********************-->

<div class="container">
<div class="row">


<!-- ****************Start of the form**********************-->
<div class="col-md-11">
<h2>Add Testcase Data</h2>
<form:form method="POST" action="/Trane_TestCase_Repository/admin_save_testcase">
<table>
<tr> 
<td><form:label path="id">Testcase ID:</form:label></td>
<td><c:out value="${testcase.id}" /></td>
<td><form:errors path="id" style="color:red"/><form:hidden path="id" value="${testcase.id}"/></td>
</tr>
<tr>
<td><form:label path="name">Testcase Name:</form:label></td>
<td><form:input path="name" value="${testcase.name}" /></td>
<td><form:errors path="name" style="color:red"/></td>
</tr>
<tr>
<td><form:label path="deviceid">Device :</form:label></td>
<td><form:select  path="deviceid" items="${devices}" itemValue="id" itemLabel="name" /></td>
<td><form:errors path="deviceid" style="color:red"/></td>
</tr>

<tr>
<td><form:label path="scenario">Testcase scenario:</form:label></td>
<td><form:input path="scenario" value="${testcase.scenario}" /></td>
<td><form:errors path="scenario" style="color:red"/></td>
</tr>
<tr>
<td><form:label path="steps">Testcase steps:</form:label></td>
<td><form:input path="steps" value="${testcase.steps}" /></td>
<td><form:errors path="steps" style="color:red"/></td>
</tr>
<tr>
<td><form:label path="testdata">Testcase testdata:</form:label></td>
<td><form:input path="testdata" value="${testcase.testdata}" /></td>
<td><form:errors path="testdata" style="color:red"/></td>
</tr>
<tr>
<td><form:label path="expectedresults">Testcase expectedresults:</form:label></td>
<td><form:input path="expectedresults" value="${testcase.expectedresults}" /></td>
<td><form:errors path="expectedresults" style="color:red"/></td>
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
<c:if test="${!empty testcases}">
<h2>List Testcases</h2>
<table class = "table">
<tr>
<th>Testcase ID</th>
<th>Testcase Name</th>
<th>Testcase Device Id</th>
<th>Testcase Scenario</th>
<th>Testcase Steps</th>
<th>Testcase Test Data</th>
<th>Testcase Expected Results</th>
<th>Action</th>
</tr>
<c:forEach items="${testcases}" var="testcase">
<tr>
<td><c:out value="${testcase.id}" /></td>
<td><c:out value="${testcase.name}" /></td>
<td><c:out value="${testcase.deviceid}" /></td>
<td><c:out value="${testcase.scenario}" /></td>
<td><c:out value="${testcase.steps}" /></td>
<td><c:out value="${testcase.testdata}" /></td>
<td><c:out value="${testcase.expectedresults}" /></td>
<td align="center"><a href="/Trane_TestCase_Repository/admin_edit_testcase?id=${testcase.id}">Edit</a>
| <a href="/Trane_TestCase_Repository/admin_delete_testcase?id=${testcase.id}">Delete</a></td>
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