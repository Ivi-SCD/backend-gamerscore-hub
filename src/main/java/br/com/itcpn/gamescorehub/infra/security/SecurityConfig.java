package br.com.itcpn.gamescorehub.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JWTSecurityFilter JWTSecurityFilter;
    @Bean
    SecurityFilterChain jwtSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth ->
                            auth
                                    .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                                    .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                                    .requestMatchers(HttpMethod.GET, "/games/**").permitAll()
                                    .requestMatchers(HttpMethod.POST, "/games/**").hasRole("ADMIN")
                                    .requestMatchers(HttpMethod.PUT, "/games/**").hasRole("ADMIN")
                                    .requestMatchers(HttpMethod.GET, "/platforms").permitAll()
                                    .requestMatchers(HttpMethod.POST, "/platforms").hasRole("ADMIN")
                                    .requestMatchers(HttpMethod.GET, "/categories").permitAll()
                                    .requestMatchers(HttpMethod.POST, "/categories").hasRole("ADMIN")
                                    .requestMatchers(HttpMethod.GET, "/users").hasRole("ADMIN")
                                    .requestMatchers(HttpMethod.PUT, "/users").hasRole("ADMIN")
                                    .requestMatchers(HttpMethod.DELETE, "/users").hasRole("ADMIN")
                                    .anyRequest().authenticated()

                )
                .addFilterBefore(JWTSecurityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
