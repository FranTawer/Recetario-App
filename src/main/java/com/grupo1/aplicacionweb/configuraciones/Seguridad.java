package com.grupo1.aplicacionweb.configuraciones;

import com.grupo1.aplicacionweb.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // habilita el preAuthorize

@Order(1)
public class Seguridad extends WebSecurityConfigurerAdapter {
    @Autowired
    private UsuarioServicio usuarioServicio;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
        auth.userDetailsService(usuarioServicio).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/*", "/js/*", "/img/*").permitAll()
                .and().formLogin()
                .loginPage("/") // Que formulario est                .successHandler(loginSuccessMessage)
                .loginProcessingUrl("/logincheck")
                .usernameParameter("email") // Como viajan los datos del logueo
                .passwordParameter("password")// Como viajan los datos del logueo
                .defaultSuccessUrl("/inicio/") // A que URL viaja
                .failureUrl("/index/?error=error")
                .permitAll()
                .and().logout() // Aca configuro la salida
                .permitAll().and().csrf().disable();
    }

    


}
