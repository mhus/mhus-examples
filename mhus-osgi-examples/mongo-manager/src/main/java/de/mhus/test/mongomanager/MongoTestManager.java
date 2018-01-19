package de.mhus.test.mongomanager;

import java.util.List;

import aQute.bnd.annotation.component.Component;
import de.mhus.karaf.mongo.MoManagerService;
import de.mhus.karaf.mongo.MoManagerServiceImpl;
import de.mhus.lib.adb.Persistable;

@Component(immediate=true,provide=MoManagerService.class)
public class MongoTestManager extends MoManagerServiceImpl {

	@Override
	public void doInitialize() {
		
	}

	@Override
	public String getServiceName() {
		return "test";
	}

	@Override
	public String getMongoDataSourceName() {
		return "local";
	}

	@Override
	protected void findObjectTypes(List<Class<? extends Persistable>> list) {
		list.add(TestPerson.class);
		list.add(TestStore.class);
		list.add(TestBook.class);
		list.add(TestMetadata.class);
	}

}
