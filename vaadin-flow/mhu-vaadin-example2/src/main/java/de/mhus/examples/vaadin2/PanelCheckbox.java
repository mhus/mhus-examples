package de.mhus.examples.vaadin2;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

// https://vaadin.com/components/vaadin-checkbox

public class PanelCheckbox extends VerticalLayout {

    private static final long serialVersionUID = 1L;

    public PanelCheckbox() {
        {
            Checkbox cb = new Checkbox("Checked");
            cb.setValue(true);
            add(cb);
            cb.addValueChangeListener(e -> {
                Notification.show("New Value: " + e.getValue());
            });
        }
        {
            Checkbox cb = new Checkbox("Unchecked");
            cb.setValue(false);
            add(cb);
        }
        
        {
            Checkbox cb = new Checkbox("Checked");
            cb.setValue(true);
            cb.setEnabled(false);
            add(cb);
        }
        {
            Checkbox cb = new Checkbox("Unchecked");
            cb.setValue(false);
            cb.setEnabled(false);
            add(cb);
        }

        {
            Checkbox cb = new Checkbox("Indeterminate");
            cb.setValue(true);
            cb.setIndeterminate(true);
            add(cb);
        }
        {
            Checkbox cb = new Checkbox("Indeterminate");
            cb.setValue(true);
            cb.setEnabled(false);
            cb.setIndeterminate(true);
            add(cb);
        }

    }
}
