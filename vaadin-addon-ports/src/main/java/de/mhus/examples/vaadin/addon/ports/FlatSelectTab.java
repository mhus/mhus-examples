package de.mhus.examples.vaadin.addon.ports;

import java.util.Arrays;

import org.vaadin.miki.flatselect.FlatSelect;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class FlatSelectTab extends Panel implements Component {

	public FlatSelectTab() {
        // Initialize our new UI component
		setSizeFull();
        final FlatSelect component = new FlatSelect("Pick one", Arrays.asList("options", "available", "in", "flat", "select", "are", "plenty"));
        component.setOptionsPerRow(1);
      //  component.setOptionWidth("100%");

        component.addValueChangeListener(e -> component.setCaption(component.getItemCaption(e.getProperty().getValue())));

        // Show it in the middle of the screen
        final VerticalLayout layout = new VerticalLayout();
        layout.setStyleName("demoContentLayout");
        layout.setSizeFull();
        layout.addComponent(component);
        layout.setComponentAlignment(component, Alignment.MIDDLE_CENTER);
        setContent(layout);

	}
}
