package com.example.spring.initializer.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.Filter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("hamsa").password("{noop}hamsa").roles("USER")
                .and()
                .withUser("nandu").password("{noop}nandu").roles("ADMIN");

    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .anyRequest()
                /*.permitAll()
                .and()*/
                .fullyAuthenticated()
                .and()
                //.addFilterBefore(SampleCustomFilter(), BasicAuthenticationFilter.class)
                .httpBasic();


        httpSecurity.csrf().disable();
    }

    @Bean
    public Filter SampleCustomFilter() {
        return new SampleCustomFilter();

    }
}
