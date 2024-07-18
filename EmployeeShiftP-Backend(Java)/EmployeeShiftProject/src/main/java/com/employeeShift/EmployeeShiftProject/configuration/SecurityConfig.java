package com.employeeShift.EmployeeShiftProject.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.employeeShift.EmployeeShiftProject.configuration.jwt.JwtAuthenticationEntryPoint;
import com.employeeShift.EmployeeShiftProject.configuration.jwt.JwtAuthenticationFilter;

@Configuration
@EnableWebMvc
public class SecurityConfig {


    @Autowired
    private JwtAuthenticationEntryPoint point;
    @Autowired
    private JwtAuthenticationFilter filter;
    
    @Autowired
    private UserDetailsService userDetailService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    

    @SuppressWarnings({ "deprecation", "removal" })
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
                //.cors().disable()
                .authorizeRequests()
                .requestMatchers("/employeeShift/auth/login").permitAll().requestMatchers("/employeeShift/registerUser").permitAll()
                .requestMatchers("/images/**").permitAll()
                .requestMatchers("/swagger-ui.html/**").permitAll() // Permit access to Swagger UI
                .requestMatchers("/v3/api-docs/**").permitAll() // Allow access to images
                .anyRequest()
                .authenticated()
                .and().exceptionHandling(ex -> ex.authenticationEntryPoint(point))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }


    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
    	DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    	daoAuthenticationProvider.setUserDetailsService(userDetailService);
    	daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
    	
    	return daoAuthenticationProvider;
    	
    }
    
    
}
