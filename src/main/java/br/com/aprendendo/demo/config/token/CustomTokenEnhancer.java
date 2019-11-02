package br.com.aprendendo.demo.config.token;

import br.com.aprendendo.demo.security.UsuarioSistema;
import java.util.HashMap;
import java.util.Map;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

public class CustomTokenEnhancer implements TokenEnhancer{

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication oaa) {
        
        UsuarioSistema usuarioSistema = (UsuarioSistema) oaa.getPrincipal();
        
        Map<String,Object> addInfo = new HashMap<>();
        addInfo.put("nome",usuarioSistema.getUsuario().getNome());
        
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(addInfo);
        
        return accessToken;
    }
    
}
