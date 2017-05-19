package de.mhus.example.lr7.portlet;

import de.mhus.lib.liferay.portlet.LiferayMVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

// https://dev.liferay.com/develop/tutorials/-/knowledge_base/7-0/creating-an-mvc-portlet

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Example Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.header-portlet-javascript=/portlet.js",
		"com.liferay.portlet.header-portlet-css=/portlet.css"
	},
	service = Portlet.class
)
public class ExamplePortlet extends LiferayMVCPortlet {

	@Override
	protected void doInit() throws PortletException {
		System.out.println("Example Portlet Initilized");
	}
}