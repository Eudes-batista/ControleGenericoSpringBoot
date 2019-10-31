package br.com.aprendendo.demo.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("springboot")
public class SpringBootProperty {

    private Seguranca seguranca = new Seguranca();

    public Seguranca getSeguranca() {
        return seguranca;
    }

    public void setSeguranca(Seguranca seguranca) {
        this.seguranca = seguranca;
    }        
    
    public static class Seguranca{
        private boolean isHttps;

        public boolean isIsHttps() {
            return isHttps;
        }

        public void setIsHttps(boolean isHttps) {
            this.isHttps = isHttps;
        }
        
    }
    
}
