package de.mhus.examples.vaadin.addon.ports;

import java.util.Date;

import com.github.wolfie.refresher.Refresher;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class RefresherTab extends VerticalLayout {
	private static final long serialVersionUID = 1L;

	private Refresher refresher;
	private Label time;

	public RefresherTab() {
		refresher = new Refresher();
		refresher.setRefreshInterval(1000);
		refresher.addListener(new Refresher.RefreshListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void refresh(Refresher source) {
				doTick();
			}
		});
		time = new Label();
		addExtension(refresher);
		addComponent(time);
	}

	protected void doTick() {
		time.setCaption(new Date().toString());
	}
	
}
