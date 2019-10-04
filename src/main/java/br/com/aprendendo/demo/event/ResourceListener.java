package br.com.aprendendo.demo.event;

import java.net.URI;
import org.springframework.context.ApplicationListener;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class ResourceListener implements ApplicationListener<ResourceCreateEvent>{
    
    @Override
    public void onApplicationEvent(ResourceCreateEvent resourceCreateEvent) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{codigo}")
                .buildAndExpand(resourceCreateEvent.getT().getPrimary())
                .toUri();
        resourceCreateEvent.getHttpServletResponse().setHeader("Location", uri.toASCIIString());
    }
    
}
