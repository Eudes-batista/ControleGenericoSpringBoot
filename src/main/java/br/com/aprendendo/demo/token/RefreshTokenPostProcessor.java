package br.com.aprendendo.demo.token;

import br.com.aprendendo.demo.config.property.SpringBootProperty;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class RefreshTokenPostProcessor implements ResponseBodyAdvice<OAuth2AccessToken> {

    @Autowired
    private SpringBootProperty springBootProperty;
    
    @Override
    public boolean supports(MethodParameter mp, Class<? extends HttpMessageConverter<?>> type) {
        return "postAccessToken".equals(mp.getMethod().getName());
    }

    @Override
    public OAuth2AccessToken beforeBodyWrite(OAuth2AccessToken t, MethodParameter mp, MediaType mt, Class<? extends HttpMessageConverter<?>> type,
             ServerHttpRequest shr, ServerHttpResponse shr1) {

        HttpServletRequest httpServletRequest = ((ServletServerHttpRequest) shr).getServletRequest();
        HttpServletResponse httpServletResponse = ((ServletServerHttpResponse) shr1).getServletResponse();

        DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) t;

        String refreshToken = t.getRefreshToken().getValue();
        adicionarRefreshTokenNoCookie(refreshToken, httpServletRequest, httpServletResponse);
        removerRefreshTokenDoCorpo(token);
        return t;
    }

    private void adicionarRefreshTokenNoCookie(String refreshToken, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Cookie cookie = new Cookie("refreshToken", refreshToken);
        cookie.setHttpOnly(true);
        cookie.setSecure(this.springBootProperty.getSeguranca().isIsHttps()); // change while for production true
        cookie.setPath(httpServletRequest.getContextPath() + "/oauth/token");
        cookie.setMaxAge(259200);
        httpServletResponse.addCookie(cookie);
    }

    private void removerRefreshTokenDoCorpo(DefaultOAuth2AccessToken token) {
        token.setRefreshToken(null);
    }

}
