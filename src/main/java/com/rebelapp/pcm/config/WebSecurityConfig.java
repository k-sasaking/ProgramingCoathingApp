package com.rebelapp.pcm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	/**
     * Web全般のセキュリティ
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/resources/**");
    }

	/**
	 * http通信のセキュリティ  
	 */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	http.authorizeRequests()
    		.anyRequest().permitAll();
    	
    }
    
    /**
     * 認証の設定
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	// 初期ユーザーの設定
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("test@rebelapp.com").password(passwordEncoder().encode("test")).roles("ADMIN");
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}