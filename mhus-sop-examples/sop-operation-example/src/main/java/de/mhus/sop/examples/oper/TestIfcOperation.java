package de.mhus.sop.examples.oper;

import java.util.Arrays;
import java.util.Date;

import aQute.bnd.annotation.component.Component;
import de.mhus.lib.core.MDate;
import de.mhus.lib.core.strategy.Operation;
import de.mhus.lib.core.strategy.OperationToIfcProxy;
import de.mhus.lib.core.util.Version;
import de.mhus.lib.karaf.services.SimpleServiceIfc;

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

}
