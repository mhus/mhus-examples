package de.mhus.examples.vaadin.addon.ports;

import org.vaadin.addons.portallayout.event.PortletCloseEvent;
import org.vaadin.addons.portallayout.event.PortletCollapseEvent;
import org.vaadin.addons.portallayout.portal.PortalBase;
import org.vaadin.addons.portallayout.portal.StackPortalLayout;
import org.vaadin.addons.portallayout.portlet.Portlet;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

public class PortalLayoutTab extends Panel implements PortletCloseEvent.Listener, PortletCollapseEvent.Listener {
	
	private static final long serialVersionUID = 1L;

    public class DemoPortal extends StackPortalLayout {
        
    	private static final long serialVersionUID = 1L;
        public DemoPortal() {
            setWidth("100%");
            setHeight("100%");
            addPortletCloseListener(PortalLayoutTab.this);
            addPortletCollapseListener(PortalLayoutTab.this);
            setMargin(true);
        }
    }
    
    private final PortalBase videoPortal = new DemoPortal() {
    	private static final long serialVersionUID = 1L;
        @Override
        public Portlet portletFor(Component c) {
            c.setHeight("300px");
            Portlet p = super.portletFor(c);
            setMargin(true);
            return p;
        }
    };
    
    private final PortalBase imagePortal = new DemoPortal() {
    	private static final long serialVersionUID = 1L;
        @Override
        public Portlet portletFor(Component c/*, int position*/) {
            setWidth("100%");
            setHeight("800px");
            c.setHeight("30%");
            Portlet p = super.portletFor(c/*, position*/);
            addPortletCloseListener(PortalLayoutTab.this);
            addPortletCollapseListener(PortalLayoutTab.this);
            setMargin(true);
            return p;
        };
    };
    
    private final PortalBase miscPortal = new DemoPortal()  {
    	private static final long serialVersionUID = 1L;
        @Override
        public Portlet portletFor(Component c/*, int position*/) {
            Portlet p = super.portletFor(c/*, position*/);
            return p;
        };
    };

    private boolean init = false;

    private final HorizontalLayout layout = new HorizontalLayout();
    
    public PortalLayoutTab() {
        super();
        setSizeFull();
        setContent(layout);
        layout.setSizeFull();
        buildPortals();
        construct();
    }

    private void buildPortals() {
        ((StackPortalLayout)videoPortal).setSpacing(false);
        ((StackPortalLayout)miscPortal).setSpacing(true);
        layout.addComponent(videoPortal);
        layout.addComponent(imagePortal);
        layout.addComponent(miscPortal);
        layout.setSpacing(true);
    }
    

    public void construct() {
        if (init)
            return;
        init = true;
        createVideoContents();
        createImageContents();
        createMiscContents();
    }
    
    private void createMiscContents() {
        for (int i = 0; i < 5; ++i) {
        	
        	Label content = new Label("Demo Content");
            Portlet portlet = miscPortal.portletFor(content);

            final HorizontalLayout header =  new HorizontalLayout();
            final TextField filterField = new TextField();
            final NativeSelect filterType = new NativeSelect();
            final Label caption = new Label("Filter: ");

            caption.addStyleName("v-white-text");
            filterField.setImmediate(true);
            header.setSizeUndefined();
            header.addComponent(caption);
            header.addComponent(filterField);
            header.addComponent(filterType);
            header.setSpacing(true);
            header.setComponentAlignment(caption, Alignment.MIDDLE_LEFT);
            header.setComponentAlignment(filterType, Alignment.MIDDLE_LEFT);
            portlet.setHeaderComponent(header);
            
            if (i == 4) {
            	content.setCaption("Locked");
            	portlet.setLocked(true);
            }
            
        }
    }

    private void createImageContents() {
    	Label content = new Label("Demo Content 2");
        Portlet portlet = miscPortal.portletFor(content);
        portlet.setClosable(false);
    }
    
    private void createVideoContents() {
        
    	Label content = new Label("Demo Content 3");
        Portlet portlet = miscPortal.portletFor(content);
        portlet.setCaption("Demo 3");
        portlet.setClosable(false);


    }

    @SuppressWarnings("deprecation")
	@Override
    public void portletCollapseStateChanged(PortletCollapseEvent event) {
        UI.getCurrent().showNotification(event.getPortlet().getParent().getCaption() + "collapsed " + event.getPortlet().isCollapsed());
    }

    @SuppressWarnings("deprecation")
	@Override
    public void portletClosed(PortletCloseEvent event) {
    	UI.getCurrent().showNotification(event.getPortlet().getParent().getCaption() + "closed");
    }

}
