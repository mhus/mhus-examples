package de.mhus.examples.vaadin.addon.ports;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class PushTab extends VerticalLayout {
	private static final long serialVersionUID = 1L;

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
