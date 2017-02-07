package de.mhus.examples.vaadin.addon.ports;

import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class ImageBrowser extends VerticalLayout implements Component {

	public ImageBrowser() {
		addComponent(new Label("ImageBrowser"));
	}
}
