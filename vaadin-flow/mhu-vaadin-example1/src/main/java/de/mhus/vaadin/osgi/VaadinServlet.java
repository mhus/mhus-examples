package de.mhus.vaadin.osgi;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.vaadin.flow.server.VaadinServletRequest;

@Component(service=Servlet.class,property= "alias=/gui",servicefactory=true)
public class VaadinServlet extends com.vaadin.flow.server.VaadinServlet {

    private static final long serialVersionUID = 1L;
    
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);

        getService().setClassLoader(getClass().getClassLoader());
    }
    
    @Override
    protected VaadinServletRequest createVaadinRequest(
            HttpServletRequest request) {
        VaadinServletRequest ret = new VaadinServletRequest(request, getService());
        return ret;
    }
    
}
