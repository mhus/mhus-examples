<%@page import="de.mhus.lib.core.MSystem"%>
<%@ include file="/init.jsp" %>
<div onclick="doItYourself();" class="example-style">
<p>
Hello World !!! This is an example: <%=MSystem.getHostname() %>
	<b><liferay-ui:message key="ExamplePortletTest01.caption"/></b>
</p>
</div>