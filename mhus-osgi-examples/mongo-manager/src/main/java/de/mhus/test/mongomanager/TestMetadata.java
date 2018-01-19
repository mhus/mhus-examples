package de.mhus.test.mongomanager;

import org.mongodb.morphia.annotations.Property;

import de.mhus.lib.basics.Named;
import de.mhus.lib.mongo.MoMetadata;

public class TestMetadata extends MoMetadata implements Named {

	@Property
	private String name;

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
