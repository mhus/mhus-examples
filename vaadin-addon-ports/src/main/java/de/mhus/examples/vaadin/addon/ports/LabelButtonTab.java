package de.mhus.examples.vaadin.addon.ports;

import java.util.HashSet;
import java.util.Set;

import org.vaadin.alump.labelbutton.LabelButton;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;

import java.util.HashSet;
import java.util.Set;

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
