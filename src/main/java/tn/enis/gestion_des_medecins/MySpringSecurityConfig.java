package tn.enis.gestion_des_medecins;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class MySpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception {
        String password1 = passwordEncoder().encode("1111");
        String password2 = passwordEncoder().encode("2222");
        String password3 = passwordEncoder().encode("3333");
        auth.inMemoryAuthentication()
                .withUser("admin").password(password1).roles("ADMIN")
                .and().withUser("patient").password(password2).roles("PATIENT")
                .and().withUser("medecin").password(password3).roles("MEDECIN");

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username as principal, password as credentials, true from user where username=?")
                .authoritiesByUsernameQuery(
                        "select user_username as principal, roles_role as role from user_roles where user_username=?")
                .rolePrefix("ROLE_");

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
    PasswordEncoder b = new BCryptPasswordEncoder();
    return b;
    }

}
