package controlpostulaciones.stroud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    /*Creamos la configuración para permitir el paso únicamente del metodo GET*/
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth->auth.requestMatchers(HttpMethod.GET, "/api/postulaciones/**").permitAll().anyRequest().authenticated());
        return http.build();
    }
}
