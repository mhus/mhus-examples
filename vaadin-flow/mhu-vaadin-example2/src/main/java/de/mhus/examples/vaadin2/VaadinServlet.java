package de.mhus.examples.vaadin2;

import javax.servlet.Servlet;

import org.osgi.service.component.annotations.Component;

import com.vaadin.flow.function.DeploymentConfiguration;
import com.vaadin.flow.server.ServiceException;
import com.vaadin.flow.server.SessionExpiredException;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.server.VaadinResponse;
import com.vaadin.flow.server.VaadinServletService;
import com.vaadin.flow.server.VaadinSession;

@Component(service=Servlet.class,property= "alias=/gui",servicefactory=true)
public class VaadinServlet extends com.vaadin.flow.server.VaadinServlet {

    private static final long serialVersionUID = 1L;
    

    @Override
    protected VaadinServletService createServletService(
            DeploymentConfiguration deploymentConfiguration)
            throws ServiceException {
        VaadinServletService service = new VaadinServletService(this,
                deploymentConfiguration) {
                    private static final long serialVersionUID = 1L;

            @Override
            public void handleRequest(VaadinRequest request, VaadinResponse response)
                    throws ServiceException {
                try {
                    VaadinSession vaadinSession = findVaadinSession(request);
                    if (vaadinSession != null) {
                        // get login info and set to thread
                        System.out.println(Thread.currentThread().getId() + " Set");
                    }
                } catch (SessionExpiredException e) {
                    
                }
                try {
                    super.handleRequest(request, response);
                } finally {
                    // remove login from thread
                    System.out.println(Thread.currentThread().getId() + " Remove");
                }
            }
            
        };
        service.init();
        return service;
    }

}
