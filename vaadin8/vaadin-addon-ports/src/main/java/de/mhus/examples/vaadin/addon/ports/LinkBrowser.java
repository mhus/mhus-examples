package de.mhus.examples.vaadin.addon.ports;

import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class LinkBrowser extends VerticalLayout implements Component {

	private static final long serialVersionUID = 1L;

	private Object funcNum;
	@SuppressWarnings("unused")
	private Object lang;

	public LinkBrowser() {
		
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
		
		addComponent(new Label("LinkBrowser"));
		{
			Button b = new Button("Link 1");
			b.addClickListener(new Button.ClickListener() {
				private static final long serialVersionUID = 1L;
				
				@Override
				public void buttonClick(ClickEvent event) {
					String myCode = "window.opener.CKEDITOR.tools.callFunction("+funcNum+", \"/nav/page.html\");window.close();";
					Page.getCurrent().getJavaScript().execute(myCode);
				}
			});
			addComponent(b);
		}
	}
}
