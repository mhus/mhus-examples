<%@page import="de.mhus.lib.core.MSystem"%>
<%@ include file="/init.jsp" %>

<p>
Hello World !!! This is an example: <%=MSystem.getHostname() %>
	<b><liferay-ui:message key="ExamplePortletTest01.caption"/></b>
</p>