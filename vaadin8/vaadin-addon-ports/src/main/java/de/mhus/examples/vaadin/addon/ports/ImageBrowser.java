package de.mhus.examples.vaadin.addon.ports;

import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class ImageBrowser extends VerticalLayout implements Component {

	private static final long serialVersionUID = 1L;
	
	private String funcNum;
	@SuppressWarnings("unused")
	private String lang;

	public ImageBrowser() {
		
		String fragment = Page.getCurrent().getUriFragment();
		fragment = fragment.split("\\?")[1];
		String[] parts = fragment.split("\\&");
		for (String part : parts) {
			if (part.startsWith("CKEditorFuncNum="))
				funcNum = part.substring("CKEditorFuncNum=".length());
			else
			if (part.startsWith("langCode="))
				lang = part.substring("langCode=".length());
		}

		addComponent(new Label("ImageBrowser"));
		
		{
			Button b = new Button("Image 1");
			b.addClickListener(new Button.ClickListener() {
				private static final long serialVersionUID = 1L;
				
				@Override
				public void buttonClick(ClickEvent event) {
					
					String img = "/VAADIN/themes/vaadinsample/img/table-logo.png";
					
					String myCode = "window.opener.CKEDITOR.tools.callFunction("+funcNum+", \""+img+"\");window.close();";
					Page.getCurrent().getJavaScript().execute(myCode);
				}
			});
			addComponent(b);
		}

	}
}
