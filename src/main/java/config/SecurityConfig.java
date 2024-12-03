package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll() // Permitir acesso a endpoints de autenticação
                .anyRequest().authenticated() // Requer autenticação para qualquer outro endpoint
            )
            .oauth2ResourceServer(oauth2 -> oauth2.jwt()); // Configuração para JWT

        return http.build();
    }
}
