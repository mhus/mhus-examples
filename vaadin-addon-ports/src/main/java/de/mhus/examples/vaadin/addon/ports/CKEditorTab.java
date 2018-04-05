package de.mhus.examples.vaadin.addon.ports;

import org.vaadin.openesignforms.ckeditor.CKEditorConfig;
import org.vaadin.openesignforms.ckeditor.CKEditorTextField;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

public class CKEditorTab extends VerticalLayout implements Component {

	private static final long serialVersionUID = 1L;
	public CKEditorTab() {
		final String editorInitialValue = 
                "<p>Thanks TinyMCEEditor for getting us started on the CKEditor integration.</p>\n\n<h1>Like TinyMCEEditor said, &quot;Vaadin rocks!&quot;</h1>\n\n<h1>And CKEditor is no slouch either.</h1>\n";

        CKEditorConfig config = new CKEditorConfig();
        config.useCompactTags();
        config.disableElementsPath();
        config.setResizeDir(CKEditorConfig.RESIZE_DIR.BOTH);
        config.disableSpellChecker();
        config.setWidth("100%");
        config.setHeight("400px");
        config.setFilebrowserImageBrowseLinkUrl("/");
        config.setFilebrowserImageBrowseUrl("/vaadinaddons#!imagebrowser");
        config.setFilebrowserImageUploadUrl("/");
        config.setFilebrowserUploadUrl("/");
        config.setFilebrowserLinkBrowseUrl("/vaadinaddons#!linkbrowser");
        final CKEditorTextField ckEditorTextField = new CKEditorTextField(config);
        addComponent(ckEditorTextField);
        
        ckEditorTextField.setValue(editorInitialValue);
        ckEditorTextField.addValueChangeListener(new Property.ValueChangeListener() {
        	private static final long serialVersionUID = 1L;
            @Override
			public void valueChange(ValueChangeEvent event) {
                Notification.show("CKEditor v" + ckEditorTextField.getVersion() + " - contents: " + event.getProperty().getValue().toString());
            }
        });
        Button button = new Button("Hit server");
        addComponents(button);
        setExpandRatio(ckEditorTextField, 0);
        setExpandRatio(button, 0);
        addComponents(new Label("x"));
        
	}
}
