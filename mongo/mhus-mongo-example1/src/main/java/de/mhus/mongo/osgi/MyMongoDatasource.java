package de.mhus.mongo.osgi;

import org.osgi.service.component.annotations.Component;

import de.mhus.karaf.mongo.api.MongoConnection;
import de.mhus.lib.mongo.xdb.MongoDataSource;

@Component(service=MongoDataSource.class,property="lookup.name=demo")
public class MyMongoDatasource extends MongoConnection {

    public MyMongoDatasource() {
        super("demo", "mongoserver", 27017);
    }

}
