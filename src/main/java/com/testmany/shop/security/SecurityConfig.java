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



//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
//        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
//    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
        auth.authenticationProvider(daoAuthenticationProvider());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http


                .authorizeRequests()
//                 .mvcMatchers("/", "/errors").permitAll() // permitAll Разрешает доступ всем
                .mvcMatchers("/login", "/registration", "/newPassword", "/newPassword/{token}", "/regConfirm/{token}").anonymous() // anonymous Разрешает доступ только анонимным
                .mvcMatchers("/admin/ADM/**").hasRole("ADMIN")
                .mvcMatchers("/user/**").hasRole("USER")
                // .anyRequest().authenticated()

                .and() /*.csrf().disable()*/
                .formLogin() // Включаем страницу с формой логина
                .loginPage("/login") // Указываем свою собственную страницу логин
                .loginProcessingUrl("/login") // Адрес обработчика, который обрабатывает
                                              // полученные данные для входа

                .defaultSuccessUrl("/")
                // Страница куда нужно перекинуть после входа.
                // Ещё можно добавить true или false. Пример ("/", true).
                // false - Если мы заходим в личный кабинет, то мы попадём в личный кабинет.
                // true - Если мы заходим в личный кабинет, то мы попадём туда, куда указали.



                // Расширенная настройка
                 .failureUrl("/login")
                // По умолчанию если указали не верный логин или пароль,
                // то возвращается та-же страница с параметром error.
                // Тут можно указать свое значение в параметре, например true



                .and()
                .logout() // Включаем процесс выхода
                // .permitAll().logoutRequestMatcher(new AntPathRequestMatcher("/logout","POST"))
                .permitAll()

                .logoutUrl("/logout") // Адрес обработчика, который обрабатывает полученные данные для выхода
                // не обязательно иметь GetMapping POST метод контроллер


                // Расширенная настройка
                .logoutSuccessUrl("/")
                // Страница куда нужно перекинуть после выхода

                .invalidateHttpSession(true) // После выхода из системы, делает сессию не действительной
                .deleteCookies("JSESSIONID"); // Удаляет куки;
    }


    @Bean
    public AuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return daoAuthenticationProvider;
    }


}
