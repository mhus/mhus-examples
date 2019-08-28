package de.mhus.examples.vaadin2;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

// https://vaadin.com/components/vaadin-dialog

public class PanelDialogbox extends VerticalLayout {

    private static final long serialVersionUID = 1L;

    public PanelDialogbox() {
        {
            Button b = new Button("Dialog");
            add(b);
            b.addClickListener(e -> showDialog());
        }
    }

    private void showDialog() {
        Dialog dialog = new Dialog();

        dialog.setCloseOnEsc(false);
        dialog.setCloseOnOutsideClick(false);

        Button confirmButton = new Button("Confirm", event -> {
            Notification.show("Confirmed!");
            dialog.close();
        });
        Button cancelButton = new Button("Cancel", event -> {
            Notification.show("Cancelled...");
            dialog.close();
        });
        
        dialog.add(confirmButton, cancelButton);
        
        dialog.open();
    }
}
