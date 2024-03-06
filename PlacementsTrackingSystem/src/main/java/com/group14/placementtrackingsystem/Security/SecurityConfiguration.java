package com.group14.placementtrackingsystem.Security;


import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * This is the web security configuration class where endpoints can be set to be authenticated or permitted without authentication.
 * @author aamd1
 * **/
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers( HttpMethod.POST, "/public/**").permitAll()
                .antMatchers( HttpMethod.GET,"/public/**", "/css/**", "/js/**" , "/Downloadables/**").permitAll()
                .anyRequest().authenticated()
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/").deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .and().oauth2Client()
                .and().oauth2Login();
    }
}
