package br.com.aprendendo.demo.event;

import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationEvent;

public class ResourceCreateEvent extends ApplicationEvent {

    private final HttpServletResponse httpServletResponse;
    private final Map<String, Object> mapParams;

    public ResourceCreateEvent(Object source, HttpServletResponse httpServletResponse, Map<String, Object> mapParams) {
        super(source);
        this.httpServletResponse = httpServletResponse;
        this.mapParams = mapParams;
    }

    public HttpServletResponse getHttpServletResponse() {
        return httpServletResponse;
    }

    public Map<String, Object> getMapParams() {
        return mapParams;
    }
    
}
