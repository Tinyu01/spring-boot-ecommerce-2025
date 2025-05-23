package org.amazon.ecommerce.auth.config;

import org.amazon.ecommerce.auth.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.logout.RedirectServerLogoutSuccessHandler;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder; // Quantum-resistant
import org.springframework.security.crypto.password.PasswordEncoder;

import java.net.URI;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    private final UserService userService;

    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) {
        http
            .authorizeExchange(exchanges -> exchanges
                .pathMatchers("/login", "/register").permitAll()
                .pathMatchers("/admin/**").hasRole("ADMIN")
                .pathMatchers("/user/**").hasRole("USER")
                .anyExchange().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .authenticationSuccessHandler((webFilterExchange, authentication) -> 
                    webFilterExchange.getExchange().getResponse()
                        .setStatusCode(org.springframework.http.HttpStatus.FOUND)
                        .setHeader("Location", "/welcome"))
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessHandler(new RedirectServerLogoutSuccessHandler()
                    .setLogoutSuccessUrl(URI.create("/login?logout")))
            )
            .csrf(csrf -> csrf.disable()); // CSRF disabled for stateless JWT
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Argon2PasswordEncoder(16, 32, 1, 65536, 10); // Quantum-resistant
    }
}