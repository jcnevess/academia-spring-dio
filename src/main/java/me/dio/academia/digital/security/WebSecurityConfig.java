package me.dio.academia.digital.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("{noop}password")
                .roles("user")
                .and()
                .withUser("root")
                .password("{noop}admin")
                .roles("manager");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/swagger-ui/*").permitAll()
                .antMatchers("/**/api-docs/**").permitAll()
                .antMatchers("/aluno").hasAnyRole("user", "manager")
                .antMatchers("/avaliacao").hasRole("manager")
                .antMatchers("/matricula").hasRole("manager")
                .anyRequest().authenticated().and().formLogin();
    }
}
