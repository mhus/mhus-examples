package de.mhus.test.mongomanager;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;

import de.mhus.lib.adb.DbComfortableObject;

public class TestBook extends DbComfortableObject {

	@Id
	ObjectId id;
	
	String name;

}
