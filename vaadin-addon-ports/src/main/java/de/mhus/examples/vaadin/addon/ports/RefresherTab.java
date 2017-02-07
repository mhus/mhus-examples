package de.mhus.examples.vaadin.addon.ports;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.jsoup.nodes.Element;

import com.github.wolfie.refresher.Refresher;
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
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.DesignContext;

import elemental.json.JsonObject;

public class RefresherTab extends VerticalLayout {

	private Refresher refresher;
	private Label time;

	public RefresherTab() {
		refresher = new Refresher();
		refresher.setRefreshInterval(1000);
		refresher.addListener(new Refresher.RefreshListener() {
			
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
