package de.mhus.test.mongomanager;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;

import de.mhus.lib.adb.Persistable;

public class TestPerson implements Persistable {

	@Id
	ObjectId id;
	
	String name;
	
}
