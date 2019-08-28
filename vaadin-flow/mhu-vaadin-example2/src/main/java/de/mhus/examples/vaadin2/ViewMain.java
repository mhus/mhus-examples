package de.mhus.examples.vaadin2;

import java.util.HashMap;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Route("")
@PWA(name = "Project Base for Vaadin Flow", shortName = "Project Base")
@Theme(Lumo.class)
public class ViewMain extends VerticalLayout {

    private static final long serialVersionUID = 1L;

    public ViewMain() {
        AppLayout appLayout = new AppLayout();
        
        
        Tabs tabs = new Tabs();
        HashMap<Tab,Component> tabsIndex = new HashMap<>();
        
        Tab tabHome = new Tab("Home");
        Div pageHome = new Div();
        pageHome.setText("Home ....");
        tabsIndex.put(tabHome, pageHome);
        tabs.add(tabHome);
        {
            Tab tab = new Tab("Checkbox");
            Component page = new PanelCheckbox();
            tabsIndex.put(tab, page);
            tabs.add(tab);
        }
        {
            Tab tab = new Tab("Combobox");
            Component page = new PanelCombobox();
            tabsIndex.put(tab, page);
            tabs.add(tab);
        }
        {
            Tab tab = new Tab("Dialog");
            Component page = new PanelDialogbox();
            tabsIndex.put(tab, page);
            tabs.add(tab);
        }
        {
            Tab tab = new Tab("Grid");
            Component page = new PanelGrid();
            tabsIndex.put(tab, page);
            tabs.add(tab);
        }
        
        Tab tabAbout = new Tab("About");
        Component pageAbout = new PanelAbout();
        tabsIndex.put(tabAbout, pageAbout);
        tabs.add(tabAbout);
//        tabsIndex.values().forEach(p -> p.setVisible(false));
        
//        new TreeSet<Tab>(tabsIndex.keySet()).forEach(k -> tabs.add(k));

        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        appLayout.addToDrawer(tabs);

        // pageAbout.setVisible(true);
        
        tabs.addSelectedChangeListener(e -> {
//            tabsIndex.values().forEach(p -> p.setVisible(false));
            Component selected = tabsIndex.get(e.getSelectedTab());
            System.out.println("Selected: " + e.getSelectedTab());
            if (selected != null)
                appLayout.setContent(selected);
        });
        
        add(appLayout);
        
        tabs.setSelectedIndex(-1);
        tabs.setSelectedIndex(0);
        
    }
}