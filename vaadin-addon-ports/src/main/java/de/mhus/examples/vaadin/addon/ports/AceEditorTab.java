package de.mhus.examples.vaadin.addon.ports;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import org.jsoup.nodes.Element;
import org.vaadin.aceeditor.AceEditor;
import org.vaadin.aceeditor.AceMode;
import org.vaadin.aceeditor.client.AceMarker;
import org.vaadin.aceeditor.client.AceRange;

import com.vaadin.server.ClientMethodInvocation;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.Extension;
import com.vaadin.server.Resource;
import com.vaadin.server.ServerRpcManager;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinResponse;
import com.vaadin.shared.communication.SharedState;
import com.vaadin.ui.Component;
import com.vaadin.ui.HasComponents;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.DesignContext;

import elemental.json.JsonObject;

public class AceEditorTab extends VerticalLayout {

	public AceEditorTab() {
		AceEditor editor = new AceEditor();
		editor.setSizeFull();
		editor.setHighlightActiveLine(true);
		editor.setShowInvisibles(true);
		editor.setValue("import abc;\n public class Test {\n  public int cnt=0;\n}\n");
		editor.addMarker(new AceRange(1, 0, 1, 0), "warning", AceMarker.Type.line, true, AceMarker.OnTextChange.ADJUST);
		editor.setMode(AceMode.java);

		setSizeFull();
		addComponent(editor);
		
	}

}
