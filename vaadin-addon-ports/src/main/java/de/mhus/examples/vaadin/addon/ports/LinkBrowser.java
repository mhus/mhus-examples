package de.mhus.examples.vaadin.addon.ports;

import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class LinkBrowser extends VerticalLayout implements Component {

	public LinkBrowser() {
		addComponent(new Label("LinkBrowser"));
	}
}
