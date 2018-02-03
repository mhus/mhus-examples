package de.mhus.sop.examples.oper;

import aQute.bnd.annotation.component.Component;
import de.mhus.lib.core.cfg.CfgString;
import de.mhus.lib.karaf.services.SimpleService;
import de.mhus.lib.karaf.services.SimpleServiceIfc;
import de.mhus.osgi.sop.api.registry.RegistryApi;

@Component(immediate=true,provide=SimpleServiceIfc.class)
public class RegistryCfgWatch extends SimpleService {

	public CfgString test = new CfgString(RegistryApi.class, "/test@string", "nothing") {
		@Override
		protected void onPostUpdate(String newValue) {
			System.out.println("Update /test@string: " + newValue);
		}
	};
	
	@Override
	public String getSimpleServiceStatus() {
		return test.value();
	}

}
