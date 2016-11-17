package de.mhus.examples.vaadin.addon.ports;

import javax.servlet.Servlet;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;

import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

import de.mhus.osgi.vaadinbridge.VaadinConfigurableResourceProviderFinder;


@Component(provide = Servlet.class, properties = { "alias=/vaadinaddons" }, name="VaadinAddonSample",servicefactory=true)
@VaadinServletConfiguration(ui=SampleUI.class, productionMode=true)
public class SampleServlet extends VaadinServlet {

	static {
	      System.setProperty("java.awt.headless", "true");
	    }
	
	private static final long serialVersionUID = 1L;

}
