package br.com.aprendendo.demo.event;

import java.net.URI;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationListener;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class ResourceListener implements ApplicationListener<ResourceCreateEvent> {

    @Override
    public void onApplicationEvent(ResourceCreateEvent resourceCreateEvent) {
        HttpServletResponse httpServletResponse = resourceCreateEvent.getHttpServletResponse();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{codigo}")
                .buildAndExpand(resourceCreateEvent.getT().getPrimary())
                .toUri();
        httpServletResponse.setHeader("Location", uri.toASCIIString());
    }

}
