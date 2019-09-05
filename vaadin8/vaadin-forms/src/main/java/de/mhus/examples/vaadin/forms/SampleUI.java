package de.mhus.examples.vaadin.forms;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/*
 * 
 * https://github.com/ahn/vaadin-aceeditor
 * 
 * 
 */
@Theme("vaadinaddons")
@Widgetset("de.mhus.examples.vaadin.addon.ports.MyAppWidgetset")
//@Widgetset(value = "com.vaadin.v7.Vaadin7WidgetSet")
public class SampleUI extends UI {

	private static final long serialVersionUID = 1L;

	@Override
	protected void init(VaadinRequest request) {
		
		TabSheet tabs = new TabSheet();
		tabs.setSizeFull();
		setContent(tabs);
		
		tabs.addTab(formEditor(), "FormEditor");
		
	}

	private Component formEditor() {
        BeanListEditorSample form = new BeanListEditorSample();
        form.initUI();
        form.setSizeFull();
        
        VerticalLayout layout = new VerticalLayout();
        
        Panel panel = new Panel(form);
        panel.setSizeFull();

        layout.addComponent(panel);
        
        layout.setMargin(false);
        layout.setSpacing(false);
        layout.setSizeFull();
        layout.setExpandRatio(panel, 1);

        return layout;
    }

    @Override
	public void detach() {
	}
	
}
