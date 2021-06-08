package com.testmany.shop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder;


    @Autowired
    UserDetailsService userDetailsService;



    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
        auth.authenticationProvider(daoAuthenticationProvider());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http


                .authorizeRequests()
//                 .mvcMatchers("/", "/errors").permitAll()
                .mvcMatchers("/login", "/registration", "/newPassword", "/newPassword/{token}", "/regConfirm/{token}").anonymous()
                .mvcMatchers("/admin/ADM/**").hasRole("ADMIN")
                .mvcMatchers("/user/**").hasRole("USER")
                // .anyRequest().authenticated()

                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")

                .defaultSuccessUrl("/")



                 .failureUrl("/login")



                .and()
                .logout()
                // .permitAll().logoutRequestMatcher(new AntPathRequestMatcher("/logout","POST"))
                .permitAll()

                .logoutUrl("/logout")


                .logoutSuccessUrl("/")

                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");
    }


    @Bean
    public AuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return daoAuthenticationProvider;
    }


}
