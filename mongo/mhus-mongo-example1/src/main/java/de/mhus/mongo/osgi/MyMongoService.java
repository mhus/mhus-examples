package de.mhus.mongo.osgi;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import de.mhus.karaf.mongo.api.MoManagerService;
import de.mhus.karaf.mongo.impl.cmd.xdb.MoManagerServiceImpl;
import de.mhus.lib.adb.Persistable;

@Component(service=MoManagerService.class,immediate=true)
public class MyMongoService extends MoManagerServiceImpl {

    @Override
    public void doInitialize() {
        System.out.println("Start moooo");
    }

    @Override
    public String getServiceName() {
        return "demo";
    }

    @Override
    public String getMongoDataSourceName() {
        return "demo";
    }

    @Override
    protected void findObjectTypes(List<Class<? extends Persistable>> list) {
        list.add(Employee.class);
        list.add(MoMetadata.class);
    }

}
