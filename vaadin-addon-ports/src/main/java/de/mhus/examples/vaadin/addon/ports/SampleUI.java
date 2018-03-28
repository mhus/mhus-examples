package de.mhus.examples.vaadin.addon.ports;

import java.io.File;

import org.vaadin.addon.borderlayout.BorderLayout;
import org.vaadin.easyuploads.ImagePreviewField;
import org.vaadin.easyuploads.MultiFileUpload;
import org.vaadin.easyuploads.UploadField;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
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
//@Push
public class SampleUI extends UI {

	private static final long serialVersionUID = 1L;

	@Override
	protected void init(VaadinRequest request) {
		
		String uri = getPage().getUriFragment();
		if (uri == null) {} else
		if (uri.startsWith("!imagebrowser?")) {
			setContent(new ImageBrowser());
			return;
		} else
		if (uri.startsWith("!linkbrowser?")) {
			setContent(new LinkBrowser());
			return;
		}
		
		
		TabSheet tabs = new TabSheet();
		tabs.setSizeFull();
		setContent(tabs);
		
		tabs.addTab(createEasyUploads(), "EasyUploads");
		tabs.addTab(new AceEditorTab(), "AceEditor");
		tabs.addTab(createBorderLayout(), "BorderLayout");
		try {
			tabs.addTab(new JFreeChartTab(), "jFreeChart");
		} catch (Throwable t) {
			t.printStackTrace();
		}
		tabs.addTab(new PortalLayoutTab(), "PortalLayout");
		tabs.addTab(new SliderPanelTab(), "SliderPanel");
		tabs.addTab(new FlatSelectTab(), "Flatselect");
		tabs.addTab(new LabelButtonTab(), "LabelButton");
		tabs.addTab(new ContextMenuButtonTab(), "ContextMenu");
//		tabs.addTab(new PushTab(), "Push");
		tabs.addTab(new RefresherTab(), "Refresher");
		tabs.addTab(new CKEditorTab(), "CKEditor");
		tabs.addTab(new MhuTableTab(), "MhusTable");
		
	}

	private Component createBorderLayout() {
		BorderLayout layout = new BorderLayout();
		layout.setSizeFull();
		
		layout.addComponent(new Label("North"), BorderLayout.Constraint.NORTH);
		layout.addComponent(new Label("South"), BorderLayout.Constraint.SOUTH);
		layout.addComponent(new Label("East"), BorderLayout.Constraint.EAST);
		layout.addComponent(new Label("West"), BorderLayout.Constraint.WEST);
		layout.addComponent(new Label("Center"), BorderLayout.Constraint.CENTER);
		
		return layout;
	}

	@SuppressWarnings("deprecation")
	private Component createEasyUploads() {
		VerticalLayout layout = new VerticalLayout();
		
		{
			layout.addComponent(new Label( "File Upload" ) );
			
			UploadField uploadField = new UploadField();
			
			Button b = new Button("Show value");
	        b.addListener(new Button.ClickListener() {
				private static final long serialVersionUID = 1L;
	
				@Override
				public void buttonClick(ClickEvent event) {
	                Object value = uploadField.getValue();
	                UI.getCurrent().showNotification("Value:" + value);
	            }
	        });
	        
	        layout.addComponent(uploadField);
	        layout.addComponent(b);
		}
        // ---
		
		{
			layout.addComponent(new Label( "Image Upload" ) );
			
			ImagePreviewField uploadField = new ImagePreviewField();
			
			Button b = new Button("Show value");
	        b.addListener(new Button.ClickListener() {
				private static final long serialVersionUID = 1L;
	
				@Override
				public void buttonClick(ClickEvent event) {
	                Object value = uploadField.getValue();
	                UI.getCurrent().showNotification("Value:" + value);
	            }
	        });
	        
	        layout.addComponent(uploadField);
	        layout.addComponent(b);
		}

		// ---
		
		{
			layout.addComponent(new Label( "Multi File Upload" ) );
			
			MultiFileUpload uploadField = new MultiFileUpload() {

				private static final long serialVersionUID = 1L;

				@Override
				protected void handleFile(File file, String fileName, String mimeType, long length) {
	                UI.getCurrent().showNotification("Uploaded: " + fileName + " " + mimeType +" Size: " + length);
	                file.delete();
				}
				
			};
	        
	        layout.addComponent(uploadField);
		}

		return layout;
	}

	@Override
	public void detach() {
	}
	
}
