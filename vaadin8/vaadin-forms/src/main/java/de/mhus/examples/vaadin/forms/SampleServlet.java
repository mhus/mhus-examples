package de.mhus.examples.vaadin.forms;

import javax.servlet.Servlet;

import org.osgi.service.component.annotations.Component;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;


@Component(service = Servlet.class, property = { "alias=/vaadinforms" }, name="VaadinFormsSample",servicefactory=true)
@VaadinServletConfiguration(ui=SampleUI.class, productionMode=false)
public class SampleServlet extends VaadinServlet {

	static {
	      System.setProperty("java.awt.headless", "true");
	    }
	
	private static final long serialVersionUID = 1L;

}
