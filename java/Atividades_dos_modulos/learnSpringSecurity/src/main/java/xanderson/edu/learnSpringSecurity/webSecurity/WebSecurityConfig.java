package xanderson.edu.learnSpringSecurity.webSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

    

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // .formLogin((form) -> form
        // 	.loginPage("/login")
        // 	.permitAll()
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/home").permitAll()
				.requestMatchers("/login").permitAll()
				.requestMatchers("/managers").hasAnyRole("MANAGERS")
                .requestMatchers("/users").hasAnyRole("USERS","MANAGERS")
				.anyRequest().authenticated()
			)
            .formLogin();

		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
			User.withDefaultPasswordEncoder()
				.username("user")
                .password("user123")
                .roles("USERS")
                .build();
        UserDetails admin =
            User.withDefaultPasswordEncoder()
				.username("admin")
                .password("admin123")
                .roles("MANAGERS")
                .build();

		return new InMemoryUserDetailsManager(user, admin);
	}
}