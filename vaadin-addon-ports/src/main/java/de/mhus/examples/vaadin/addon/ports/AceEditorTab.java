package de.mhus.examples.vaadin.addon.ports;

import org.vaadin.aceeditor.AceEditor;
import org.vaadin.aceeditor.AceMode;
import org.vaadin.aceeditor.client.AceMarker;
import org.vaadin.aceeditor.client.AceRange;

import com.vaadin.ui.VerticalLayout;

public class AceEditorTab extends VerticalLayout {

	private static final long serialVersionUID = 1L;

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
