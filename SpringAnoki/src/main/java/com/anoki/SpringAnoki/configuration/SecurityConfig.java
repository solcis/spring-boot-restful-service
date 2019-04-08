package com.anoki.SpringAnoki.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/**").
            hasRole("USER")
            .and().formLogin()
            .defaultSuccessUrl("/api/customers",true)
            .and()
            .csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
		      throws Exception {
		        auth
		          .inMemoryAuthentication()
		          .withUser("user")
		            .password(encoder().encode("password"))
		            .roles("USER")
		            .and()
		          .withUser("admin")
		            .password(encoder().encode("admin"))
		            .roles("USER", "ADMIN");
		}
	
	@Bean
	public PasswordEncoder  encoder() {
	    return new BCryptPasswordEncoder();
	}
	
}
