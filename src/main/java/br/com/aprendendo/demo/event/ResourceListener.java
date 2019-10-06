package br.com.aprendendo.demo.event;

import java.net.URI;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class ResourceListener implements ApplicationListener<ResourceCreateEvent> {

    @Override
    public void onApplicationEvent(ResourceCreateEvent resourceCreateEvent) {
        HttpServletResponse httpServletResponse = resourceCreateEvent.getHttpServletResponse();
        Map<String, Object> mapParams = resourceCreateEvent.getMapParams();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path(this.criarPath(mapParams))
                .buildAndExpand(mapParams)
                .toUri();
        httpServletResponse.setHeader("Location", uri.toASCIIString());
    }

    private String criarPath(Map<String, Object> mapParams) {
        return mapParams.keySet().stream().map(key -> "/{" + key + "}").collect(Collectors.joining());
    }

}
