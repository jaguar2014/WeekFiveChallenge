package com.ashu.demo.security;


import com.ashu.demo.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    AppUserRepository userRepository;

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new SSUDS(userRepository);
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//     auth.inMemoryAuthentication().withUser("applicant").password("pass").authorities("APPLICANT")
//             .and()
//             .withUser("employer").password("emppass").authorities("EMPLOYER");

        auth.userDetailsService(userDetailsServiceBean());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/vendor/**","/image/**","/css/**","/js/**","/scss/**","/h2-console/**").permitAll()
                .antMatchers("/addcontact","/addeducation","/addexperience","/addskill","/addreference","/buildcover","/displaycover","/cover","/contact","/education","/experience","/skill","/reference","/summary")
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



    }
}
