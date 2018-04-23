package de.mhus.sop.examples.oper;

import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Service;

import de.mhus.lib.core.MApi;
import de.mhus.osgi.services.SimpleServiceIfc;
import de.mhus.osgi.sop.api.operation.OperationAddress;
import de.mhus.osgi.sop.api.operation.OperationApi;
import de.mhus.osgi.sop.api.operation.OperationDescriptor;
import de.mhus.osgi.sop.api.operation.OperationUtil;

@Command(scope = "example", name = "testifc", description = "Execute Test Ifc Operation")
@Service
public class CmdTestIfcOperation implements Action {

	@Argument(index=0, name="addr", required=false, description="Address", multiValued=false)
    String addr = "local://de.mhus.sop.examples.oper.TestIfcOperation:1.0.0";

	@Override
	public Object execute() throws Exception {
		
		OperationApi api = MApi.lookup(OperationApi.class);
		
		OperationDescriptor desc = api.getOperation(new OperationAddress(addr));

		SimpleServiceIfc proxy = OperationUtil.createOpertionProxy(SimpleServiceIfc.class, desc);
		
		proxy.doSimpleServiceCommand("cmd", "a", "b", "c");
		
		System.out.println(proxy.getSimpleServiceInfo());
		System.out.println(proxy.getSimpleServiceStatus());
		
		return null;
	}

}
