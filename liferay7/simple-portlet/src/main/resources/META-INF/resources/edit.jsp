<%@ include file="/init.jsp" %>

<div class="sample-portlet">
	<jsp:useBean class="java.lang.String" id="addNameURL" scope="request" />
	<form
    id="<portlet:namespace />helloForm"
    action="<%= addNameURL %>"
    method="post">
		<table> <tr>
		<td>Name:</td>
		            <td><input type="text" name="username"></td>
		        </tr>
		</table>
    <input type="submit" id="nameButton" title="Add Name" value="Add Name">
</form>
</div>