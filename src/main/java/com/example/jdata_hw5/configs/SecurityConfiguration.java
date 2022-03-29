package com.example.jdata_hw5.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //{noop} - провайдер для шифровки пароля. noop - No Operation. Ничего не делает с этим паролем
        auth.inMemoryAuthentication()
                .withUser("User1").password("{noop}password1").authorities("getPersonsByCity", "getPersonsByAge")
                .and()
                .withUser("User2").password("{noop}password2").authorities("getPersonsByCity", "getPersonsByAge")
                .and()
                .withUser("Admin").password("{noop}qwerty").authorities("getPersonsByCity", "getPersonsByAge", "getPersonsByNameAndSurname");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // Для метода hello доступ разрешен всем
        httpSecurity.formLogin()
                .and()
                .authorizeRequests().antMatchers("/hello").permitAll()
                .and()
                .authorizeRequests().antMatchers("/persons/by-city").hasAuthority("getPersonsByCity")
                .and()
                .authorizeRequests().antMatchers("/persons/by-age").hasAuthority("getPersonsByAge")
                .and()
                .authorizeRequests().antMatchers("/persons/byNameAndSurname").hasAuthority("getPersonsByNameAndSurname")
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }
}