package de.mhus.examples.vaadin.addon.ports;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

public class LabelButtonTab extends VerticalLayout implements Component {

	public LabelButtonTab() {
		
		setSpacing(true);
		setMargin(true);
		
		{
			Button b = new Button("Flat Button");
			b.setStyleName("flatbutton");
			addComponent(b);
		}
		{
			Button b = new Button("Label Button");
			b.setStyleName("labelbutton");
			addComponent(b);
		}
	}
}
