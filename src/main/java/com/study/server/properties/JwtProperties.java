package com.study.server.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Data
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {
    private KeyStore keyStore;
    private String issuer;

    @Data
    public static class KeyStore {
        private String location;
        private String password;
        private String alias;
        private String passphrase;
    }
}
