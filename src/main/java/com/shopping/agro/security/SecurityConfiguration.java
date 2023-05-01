package com.shopping.agro.security;

import com.shopping.agro.handlers.AppAuthenticationSuccessHandler;
import com.shopping.agro.services.UserCredentialsDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;
    @Autowired
    private UserCredentialsDetailsService userCredentialsDetailsService;


    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userCredentialsDetailsService);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/images/**","/v1/product").permitAll()
                .antMatchers("/updateItem","/deleteItem","/addItem").hasAnyRole("ADMIN", "admin")
                .antMatchers("/").hasAnyRole("ADMIN","USER", "user", "admin")
                .antMatchers("/index").hasAnyRole("ADMIN","USER", "user", "admin")
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(appAuthenticationSuccessHandler())
                .failureUrl("/login?error=true")
                .permitAll()
                .defaultSuccessUrl("/index")
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout=true")
                .permitAll();

    }
    @Bean
    public AuthenticationSuccessHandler appAuthenticationSuccessHandler(){
        return new AppAuthenticationSuccessHandler();
    }
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
