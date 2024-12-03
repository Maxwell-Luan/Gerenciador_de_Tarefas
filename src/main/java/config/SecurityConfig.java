package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()  // Desabilita CSRF globalmente
            .authorizeRequests(auth -> auth
                .requestMatchers("/api/auth/register").permitAll() // Permite a rota de registro sem autenticação
                .anyRequest().authenticated() // Requer autenticação para qualquer outro endpoint
            );

        return http.build();
    }
}
