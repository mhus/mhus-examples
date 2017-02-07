package de.mhus.examples.vaadin.addon.ports;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import org.jsoup.nodes.Element;

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

public class PushTab extends VerticalLayout {

	private Timer timer;
	private Label time;

	public PushTab() {
		
		addComponent(new Label("Time:"));
		time = new Label();
		addComponent(time);
		
		timer = new Timer(true);
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				doTick();
			}
		}, 1000, 1000);
	}

	protected void doTick() {
		if (getUI() == null) return;
		getUI().access(new Runnable() {
			
			@Override
			public void run() {
				time.setValue( new Date().toString() );
			}
		});
	}

	@Override
	protected void finalize() {
		timer.cancel();
	}

}
