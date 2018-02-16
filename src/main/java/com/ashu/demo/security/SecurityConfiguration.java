package com.ashu.demo.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
     auth.inMemoryAuthentication().withUser("applicant").password("pass").authorities("APPLICANT")
             .and()
             .withUser("employer").password("emppass").authorities("EMPLOYER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/vendor/**","/image/**","/css/**","/js/**","/scss/**","/h2-console/**").permitAll()
                .antMatchers("/addcontact","/addeducation","/addexperience","/addskill","/addreference","/contact","/education","/experience","/skill","/reference","/summary")
                .access("hasAuthority('APPLICANT')")
                .antMatchers("/displaycompletedresume","/displaycompletedcover").access("hasAuthority('APPLICANT') or hasAuthority('EMPLOYER')")
                .anyRequest().authenticated()

                .and()
                .formLogin().loginPage("/login").permitAll()
               .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login").permitAll().permitAll()
                .and().httpBasic() ;



        http.csrf().disable();

        http.headers().frameOptions().disable();

    }
}
