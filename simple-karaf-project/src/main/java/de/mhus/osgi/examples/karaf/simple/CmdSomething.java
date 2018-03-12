package de.mhus.osgi.examples.karaf.simple;

import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.Option;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

@Command(scope = "sample", name = "something", description = "Call the do something service")
@Service
public class CmdSomething implements Action {

	@Argument(index=0, name="input", required=true, description="Input for the service", multiValued=false)
    String input;
	
    @Option(name = "-f", aliases = { "--filter" }, description = "Service filter", required = false, multiValued = false)
    String filter;

	@Override
	public Object execute() throws Exception {
		
		BundleContext context = FrameworkUtil.getBundle(CmdSomething.class).getBundleContext();

		for (ServiceReference<SomethingServiceIfc> ref : context.getServiceReferences(SomethingServiceIfc.class, filter)) {
			System.out.println("Calling " + ref);
			SomethingServiceIfc service = context.getService(ref);
			String output = service.doSomething(input);
			System.out.println("Result: " + output);
			System.out.println();
		}
		
		return null;
	}
	
}
