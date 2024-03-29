package br.com.aprendendo.demo.token;

import java.io.IOException;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.apache.catalina.util.ParameterMap;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Profile("oauth-security")
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RefreshTokenCookiePreProcessorFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        if (!this.verificarRefreshTokenExiste(req)) {
            chain.doFilter(request, response);
            return;
        }
        for (Cookie cookie : req.getCookies()) {
            if ("refreshToken".equals(cookie.getName())) {
                String refreshToken = cookie.getValue();
                req = new MyServletRequestWrapper(req, refreshToken);
                break;
            }
        }
        chain.doFilter(request, response);
    }

    private boolean verificarRefreshTokenExiste(HttpServletRequest req) {
        return "/oauth/token".equalsIgnoreCase(req.getRequestURI()) && "refresh_token".equals(req.getParameter("grant_type")) && req.getCookies() != null;
    }

    static class MyServletRequestWrapper extends HttpServletRequestWrapper {

        private final String refreshToken;

        public MyServletRequestWrapper(HttpServletRequest request, String refreshToken) {
            super(request);
            this.refreshToken = refreshToken;
        }

        @Override
        public Map<String, String[]> getParameterMap() {
            ParameterMap<String, String[]> map = new ParameterMap<>(getRequest().getParameterMap());
            map.put("refresh_token", new String[]{this.refreshToken});
            map.setLocked(true);
            return map;
        }

    }

}
