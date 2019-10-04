package br.com.aprendendo.demo.event;

import br.com.aprendendo.demo.model.base.EntityBase;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationEvent;

public class ResourceCreateEvent<T extends EntityBase> extends ApplicationEvent{
    
    private final HttpServletResponse httpServletResponse;
    private T t;
    
    public ResourceCreateEvent(Object source,HttpServletResponse httpServletResponse,T t) {
        super(source);
        this.httpServletResponse = httpServletResponse;
        this.t = t;
    }

    public HttpServletResponse getHttpServletResponse() {
        return httpServletResponse;
    }

    public T getT() {
        return t;
    }
    
    
}
