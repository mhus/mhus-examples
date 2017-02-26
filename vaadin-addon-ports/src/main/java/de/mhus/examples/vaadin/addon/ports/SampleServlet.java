package de.mhus.examples.vaadin.addon.ports;

import javax.servlet.Servlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

import aQute.bnd.annotation.component.Component;


@Component(provide = Servlet.class, properties = { "alias=/vaadinaddons" }, name="VaadinAddonSample",servicefactory=true)
@VaadinServletConfiguration(ui=SampleUI.class, productionMode=false)
public class SampleServlet extends VaadinServlet {

	static {
	      System.setProperty("java.awt.headless", "true");
	    }
	
	private static final long serialVersionUID = 1L;

}
