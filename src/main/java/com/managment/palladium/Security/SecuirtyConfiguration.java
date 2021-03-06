package com.managment.palladium.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecuirtyConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    BCryptPasswordEncoder bCryptEncoder;

    // Authentication used to load in data from the database and check where the info is matching
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication()
                .usersByUsernameQuery("select username, password, enabled " + "from user_accounts where username = ?" )
                .authoritiesByUsernameQuery("select username, role " + "from user_accounts where username = ? ")
                .dataSource(dataSource)
                .passwordEncoder(bCryptEncoder);

    }

    // Security settings, which can be changed regarding the user ROLE
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/").hasAuthority("ADMIN")
//                .antMatchers("/projects/save").hasAuthority("ADMIN")
//                .antMatchers("/employees/new").hasAuthority("ADMIN")
//                .antMatchers("/employees/save").hasAuthority("ADMIN")
                .and()
                .formLogin();

    }

}
