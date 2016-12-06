package de.mhus.examples.vaadin.addon.ports;

import org.vaadin.peter.contextmenu.ContextMenu;
import org.vaadin.peter.contextmenu.ContextMenu.ContextMenuItem;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class ContextMenuButtonTab extends VerticalLayout implements Component {

	public ContextMenuButtonTab() {
		Button b = new Button("Click");
		b.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				
				ContextMenu menu = new ContextMenu();

				// Generate main level items
				ContextMenuItem photos = menu.addItem("Photos");
				ContextMenuItem albums = menu.addItem("Albums");
				ContextMenuItem report = menu.addItem("Report");

				// Generate sub item to photos menu
				ContextMenuItem topRated = photos.addItem("Top rated");

				photos.setIcon(FontAwesome.PHOTO);

				// Enable separator line under this item
				photos.setSeparatorVisible(true);
				
				menu.open(b);
				
			}
		});
		addComponent(b);
	}
	
}
