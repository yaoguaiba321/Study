package com.study.server.security;

import com.study.server.properties.JwtProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.*;

import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Objects;

@Configuration
public class JwtConfiguration {
    @Autowired
    private JwtProperties jwtProperties;

    @Bean
    public KeyStore keyStore() {
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(this.jwtProperties.getKeyStore().getLocation());
            keyStore.load(resourceAsStream, this.jwtProperties.getKeyStore().getPassword().toCharArray());
            return keyStore;
        } catch (IOException | CertificateException | NoSuchAlgorithmException | KeyStoreException e) {
//            log.error("Unable to load keystore: {}", this.jwtProperties.getKeyStore().getLocation(), e);
        }

        throw new IllegalArgumentException("Unable to load keystore");
    }

    @Bean
    public RSAPrivateKey jwtSigningKey(KeyStore keyStore) {
        try {
            Key key = keyStore.getKey(this.jwtProperties.getKeyStore().getAlias(), this.jwtProperties.getKeyStore().getPassphrase().toCharArray());
            if (key instanceof RSAPrivateKey) {
                return (RSAPrivateKey) key;
            }
        } catch (UnrecoverableKeyException | NoSuchAlgorithmException | KeyStoreException e) {
//            log.error("Unable to load private key from keystore: {}", this.jwtProperties.getKeyStore().getLocation(), e);
        }

        throw new IllegalArgumentException("Unable to load private key");
    }

    @Bean
    public RSAPublicKey jwtValidationKey(KeyStore keyStore) {
        try {
            Certificate certificate = keyStore.getCertificate(this.jwtProperties.getKeyStore().getAlias());
            PublicKey publicKey = certificate.getPublicKey();

            if (publicKey instanceof RSAPublicKey) {
                return (RSAPublicKey) publicKey;
            }
        } catch (KeyStoreException e) {
//            log.error("Unable to load private key from keystore: {}", this.jwtProperties.getKeyStore().getLocation(), e);
        }

        throw new IllegalArgumentException("Unable to load RSA public key");
    }

    @Bean
    public JwtDecoder jwtDecoder(RSAPublicKey rsaPublicKey) {
        NimbusJwtDecoder result = NimbusJwtDecoder.withPublicKey(rsaPublicKey).build();
        result.setJwtValidator(
                new DelegatingOAuth2TokenValidator<Jwt>(
                        JwtValidators.createDefaultWithIssuer(jwtProperties.getIssuer()),
                        new JwtClaimValidator<>("id", Objects::nonNull),
                        new JwtClaimValidator<>("nickname", Objects::nonNull))
        );
        return result;
    }
}
