package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.server.resource.introspection.OpaqueTokenIntrospector;

@Configuration
public class OpaqueTokenConfig {

    @Bean
    public OpaqueTokenIntrospector introspector() {
        return token -> {
            throw new UnsupportedOperationException("Introspecção de token não configurada.");
        };
    }
}
