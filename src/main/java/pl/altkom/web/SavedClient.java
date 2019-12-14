package pl.altkom.web;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class SavedClient implements ServletRequestAttributeListener {

    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        Object counter = servletRequestAttributeEvent.
                getServletContext().
                getAttribute("savedClientCounter");
        int c;
        if(counter!=null)
             c = Integer.valueOf(counter.toString());
        else c=0;

        c++;

        servletRequestAttributeEvent.getServletContext().setAttribute("savedClientCounter",c);
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {

    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {

    }
}
