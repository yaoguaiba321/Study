package com.study.server.security;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.study.server.excepiton.StudyException;
import com.study.server.properties.JwtProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.security.interfaces.RSAPrivateKey;
import java.text.ParseException;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@Component
public class JwtHelper {
    @Autowired
    private JwtProperties jwtProperties;
    private final RSAPrivateKey privateKey;

    public JwtHelper(RSAPrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    public String createJwtForClaims(String subject, Map<String, String> claims) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(Instant.now().toEpochMilli());
        calendar.add(Calendar.DATE, 30);

        JWTClaimsSet.Builder builder = new JWTClaimsSet.Builder()
                .subject(subject)
                .notBeforeTime(new Date())
                .expirationTime(calendar.getTime())
                .issuer(jwtProperties.getIssuer());
        claims.forEach(builder::claim);
        SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.RS256), builder.build());

        JWSSigner signer = new RSASSASigner(privateKey);
        try {
            signedJWT.sign(signer);
            return signedJWT.serialize();
        } catch (JOSEException e) {
            throw new StudyException("JWT生成失败");
        }
    }

    public boolean validateToken(String authToken) {
        String idStr = null;
        try {
            SignedJWT jwt = SignedJWT.parse(authToken);
            idStr = jwt.getJWTClaimsSet().getStringClaim("id");
            return true;
        } catch (ParseException e) {
            throw new StudyException("令牌无效");
        }
        return false;
    }

    public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
