package org.sid.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigureAdapter {
   @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws  Exception{

        /*
        // withuser pour specifier lutilisateur
        auth.inMemoryAuthentication().withUser("admin").password("1234").roles("USER","ADMIN");
        auth.inMemoryAuthentication().withUser("user").password("1234").roles("USER");
    */
        // avec un utilisateur qui a la base de donner
        auth.jdbcAuthentication().dataSource(dataSource)
        .userByUsernameQuery("select  login as principal ,pass as crendentials from users where login=?")
                .authoritiezByUsername("select  login as principal ,pass as crendentials from users_role where login=? ")
                .passwordEncoder(new Md5PasswordEncoder())
                .rolePrefix("Role_");
        }

    @Override
    protected void configure(HttpSecurity http) throws  Exception{
        // pour definir les regles des security
        http.formLogin().loginPage("/login");
        auth.csrf.disable();
        http.authorizeRequests().andMatchers("/user/*").hasRole("USER");
        http.authorizeRequests().andMatchers("/admin/*").hasRole("ADMIN");
        //personnaliser un message error
        http.exceptionHandling().accessDeniedPage("/403");
    }
}
