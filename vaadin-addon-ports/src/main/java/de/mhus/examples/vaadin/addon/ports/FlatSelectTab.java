package de.mhus.examples.vaadin.addon.ports;

import java.util.Arrays;

import org.vaadin.miki.flatselect.FlatSelect;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class FlatSelectTab extends VerticalLayout implements Component {

	public FlatSelectTab() {
        // Initialize our new UI component
		setSizeFull();
//		addStyleName("flatselect");
		{
			HorizontalLayout container = new HorizontalLayout();
	        final FlatSelect component = new FlatSelect("Pick one", Arrays.asList("options", "available", "in", "flat", "select", "are", "plenty"));
	        container.addStyleName("flatlabel");
	        container.addStyleName("flatleft");
	        container.addStyleName("flatselectable");
	        component.setOptionsPerRow(2);
	        component.setOptionsWidth("200px");
	
	        component.addValueChangeListener(e -> component.setCaption(component.getItemCaption(e.getProperty().getValue())));
	
	        // Show it in the middle of the screen
	        final VerticalLayout layout = new VerticalLayout();
	        layout.setStyleName("demoContentLayout");
	        layout.setSizeFull();
	        layout.addComponent(component);
	        layout.setComponentAlignment(component, Alignment.MIDDLE_CENTER);
	        container.addComponent(layout);
	        addComponent(container);
		}
		{
			HorizontalLayout container = new HorizontalLayout();
	        final FlatSelect component = new FlatSelect("Pick one", Arrays.asList("options", "available", "in", "flat", "select", "are", "plenty"));
	        container.addStyleName("flatselectable");
	        component.setOptionsPerRow(2);
	        component.setOptionsWidth("200px");
	
	        component.addValueChangeListener(e -> component.setCaption(component.getItemCaption(e.getProperty().getValue())));
	
	        // Show it in the middle of the screen
	        final VerticalLayout layout = new VerticalLayout();
	        layout.setStyleName("demoContentLayout");
	        layout.setSizeFull();
	        layout.addComponent(component);
	        layout.setComponentAlignment(component, Alignment.MIDDLE_CENTER);
	        container.addComponent(layout);
	        addComponent(container);
		}
		{
			HorizontalLayout container = new HorizontalLayout();
	        final FlatSelect component = new FlatSelect("Pick one", Arrays.asList("options", "available", "in", "flat", "select", "are", "plenty"));
	        container.addStyleName("flatselect");
	        container.addStyleName("flatleft");
	        container.addStyleName("flatselectable");
	        component.setOptionsPerRow(2);
	        component.setOptionsWidth("200px");
	
	        component.addValueChangeListener(e -> Notification.show("Click " + e.getProperty().getValue() ) );
	
	        // Show it in the middle of the screen
	        final VerticalLayout layout = new VerticalLayout();
	        layout.setStyleName("demoContentLayout");
	        layout.setSizeFull();
	        layout.addComponent(component);
	        layout.setComponentAlignment(component, Alignment.MIDDLE_CENTER);
	        container.addComponent(layout);
	        addComponent(container);
		}
	}
}
