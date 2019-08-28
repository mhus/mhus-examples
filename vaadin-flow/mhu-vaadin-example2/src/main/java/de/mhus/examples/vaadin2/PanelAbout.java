package de.mhus.examples.vaadin2;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class PanelAbout extends VerticalLayout {

    private static final long serialVersionUID = 1L;

    public PanelAbout() {
        add(new Label("Mike Hummel"));
        Anchor url = new Anchor("http://www.mhus.de", "Homepage");
        url.setTarget("_blank");
        add(url);
        add(new Anchor("mailto:webmaster@mhus.de", "E-Mail"));
    }
}
