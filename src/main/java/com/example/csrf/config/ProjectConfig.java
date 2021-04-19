package com.example.csrf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {
    @Override
    @Bean
    public UserDetailsService userDetailsService(){
        var manager = new InMemoryUserDetailsManager();

        var user1 = User.withUsername("john")
                .password("1234")
                .roles("ADMIN")
                .build();

        var user2 = User.withUsername("jane")
                .password("1234")
                .roles("MANAGER")
                .build();
        manager.createUser(user1);
        manager.createUser(user2);
        return manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();

   /*     http.authorizeRequests()
           //     .mvcMatchers(HttpMethod.GET,"/a").authenticated()
           //     .mvcMatchers(HttpMethod.POST,"/a").permitAll()  //permit all will not check username password
                .mvcMatchers("/a/b/**").authenticated()
                .mvcMatchers("/product/{code:^[0-9]*$}")
                .permitAll();

        http.csrf().disable();

    */

        /*
        http.authorizeRequests()
                .mvcMatchers("/product/{code:^[0-9]*$}")
                .permitAll()
                .anyRequest()
                .denyAll();
        http.csrf().disable();

         */
      /*  http.authorizeRequests()
                .mvcMatchers("/hello").authenticated();


        http.authorizeRequests()
                .antMatchers("/hello").authenticated();

       */

        http.authorizeRequests()
                .mvcMatchers("/email/{email:.*(.+@.+\\.com)}")
                .permitAll()
                .anyRequest()
                .denyAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
