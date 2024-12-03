package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import javax.crypto.spec.SecretKeySpec;

@Configuration
public class JwtConfig {

    @Bean
    public JwtDecoder jwtDecoder() {
        // Chave secreta usada para assinar os tokens (substitua pela sua)
        String secretKey = "sua-chave-secreta";
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");

        // Retorna o JwtDecoder configurado com a chave secreta
        return NimbusJwtDecoder.withSecretKey(secretKeySpec).build();
    }
}
