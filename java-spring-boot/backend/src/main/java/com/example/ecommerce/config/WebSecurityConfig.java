package com.example.ecommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DatabaseAuthenticationProvider authProvider;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("WebSecurityConfig.configAuthentication()");

        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //System.out.println("bcrypt password: " + passwordEncoder.encode("test12345").toString());

        auth.authenticationProvider(authProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().
            and().
            authorizeRequests().
            antMatchers("/**").hasRole("ADMIN").
            anyRequest().authenticated();
    }
}

/*
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("WebSecurityConfig.configure()");

        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        System.out.println("bcrypt password: " + passwordEncoder.encode("test12345").toString());

        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("user")
                .password(passwordEncoder().encode("test12345"))
                .roles("USER")
                .and()
                .withUser("admin")
                .password(passwordEncoder().encode("test12345"))
                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
*/