package de.mhus.osgi.examples.karaf.simple;

import java.util.Date;

import org.osgi.service.component.ComponentContext;

import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Deactivate;

@Component
public class SomethingServiceImpl implements SomethingServiceIfc {

	@Activate
	public void doActivate(ComponentContext ctx) {
		System.out.println("Start Simple Service");
	}
	
	@Deactivate
	public void doDeactivate(ComponentContext ctx) {
		System.out.println("Stop Simple Service");
	}

	@Override
	public String doSomething(String in) {
		System.out.println("Call doSomething: " + in);
		return new Date() + ": " + in;
	}

}
