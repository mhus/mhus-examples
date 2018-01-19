package de.mhus.test.mongomanager;

import java.util.HashMap;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

import de.mhus.lib.adb.DbComfortableObject;

public class TestBook extends DbComfortableObject {

	@Id
	ObjectId id;
	
	@Property
	String name;
	
	@Property
	HashMap<String, String> meta;

}
