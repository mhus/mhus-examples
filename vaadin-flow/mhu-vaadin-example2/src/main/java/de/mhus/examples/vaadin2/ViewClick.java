package de.mhus.examples.vaadin2;

import java.util.Date;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Route("click")
@PWA(name = "Click Vaadin Flow Route", shortName = "Click")
@Theme(Lumo.class)
public class ViewClick extends VerticalLayout {

    private static final long serialVersionUID = 1L;

    public ViewClick() {
        Button button = new Button("Click me",
                event -> {
                    System.out.println("Clicked");
                    Notification.show("Clicked! " + new Date());
                });
        add(button);
    }
}