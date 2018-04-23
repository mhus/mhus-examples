package de.mhus.sop.examples.oper;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import aQute.bnd.annotation.component.Component;
import de.mhus.lib.core.MDate;
import de.mhus.lib.core.strategy.Operation;
import de.mhus.lib.core.strategy.OperationDescription;
import de.mhus.lib.core.strategy.OperationToIfcProxy;
import de.mhus.lib.core.util.Version;
import de.mhus.osgi.services.SimpleServiceIfc;

@Component(provide=Operation.class,immediate=true)
public class TestIfcOperation extends OperationToIfcProxy implements SimpleServiceIfc {

	@Override
	protected Class<?> getInterfaceClass() {
		return SimpleServiceIfc.class;
	}

	@Override
	protected Object getInterfaceObject() {
		return this;
	}

	@Override
	protected Version getInterfaceVersion() {
		return new Version("1.0.0");
	}

	@Override
	public String getSimpleServiceInfo() {
		return "Info Time: " + MDate.toIso8601(new Date());
	}

	@Override
	public String getSimpleServiceStatus() {
		return "Status Time: " + MDate.toIso8601(new Date());
	}

	@Override
	public void doSimpleServiceCommand(String cmd, Object... param) {
		System.out.println(cmd + ": " + Arrays.deepToString(param));
	}

	@Override
	protected void initOperationDescription(HashMap<String, String> parameters) {
		parameters.put(OperationDescription.TAGS, "test");
	}

}
