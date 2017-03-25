<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file = "header.jsp"  %>

<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>


<body bgcolor = "#000000">



<div style="text-align:center">
<h2><font color = "black"> Enter your Credentials </font> </h2> 
<hr>
</div>

<div class = "container"> 
<div class = "row"> 
<div class = "col-sm-4"></div> 
<div class = "col-sm-5">


<form:form method="POST" action="/Trane_TestCase_Repository/all_addUser">
    
<table class = "table">
<tr>
<td><form:label path="uname">USERNAME</form:label></td>
<td><form:input path="uname" id ="_iusername"/></td>
<td><form:errors path="uname" style="color:red"/></td>
</tr>

<tr>
<td><form:label path="firstname">FIRSTNAME</form:label></td>
<td><form:input path="firstname" id = "_ifirstname" /></td>
<td><form:errors path="firstname" style="color:red"/></td>
</tr>

<tr>
<td><form:label path="lastname">LASTNAME</form:label></td>
<td><form:input path="lastname" id = "_ilastname" /></td>
<td><form:errors path="lastname" style="color:red"/></td>
</tr>

<tr>
<td><form:label path="middlename">MIDDLENAME</form:label></td>
<td><form:input path="middlename" id = "_imiddlename" /></td>
<td><form:errors path="middlename" style="color:red"/></td>
</tr>

<tr>
<td><form:label path="sex">SEX</form:label></td>
<td><form:radiobutton path="sex" value="Male" checked="checked"/>Male
<form:radiobutton path="sex" value="Female"/>Female</td>
<td><form:errors path="sex" style="color:red"/></td>
</tr>

<tr>
<td><form:label path="personalphone">PHONE</form:label></td>
<td><form:input path="personalphone" id = "_iphone"/></td>
<td><form:errors path="personalphone" style="color:red" /></td>
</tr>

<tr>
<td><form:label path="password">PASSWORD</form:label></td>
<td><form:input type ="password" path="password" id = "_ipassword"/></td>
<td><form:errors path="password" style="color:red"/></td>
</tr>

<tr>
<td><form:label path="confirmpassword">CONFIRM PASSWORD</form:label></td>
<td><form:input type ="password" path="confirmpassword" id = "_iconfirm_password"/></td>
<td><form:errors path="confirmpassword" style="color:red"/></td>
</tr>
        
<tr>
 <td colspan="2">
 <input type="submit" value="Submit"/>
</td>
</tr>

</table>    

</form:form>
   
</div>	

    
</div>
</div>
          
 <div>            

</div>
</body>
</html>

<%@include file = "footer.jsp"  %>