package com.rebelapp.pcm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService accountServiceImpl;

	@Autowired
	AuthenticationSuccessHandler loginSuccessHandler;

	@Autowired
	AuthenticationFailureHandler loginFailureHandler;

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
			.antMatchers("/css/**","/js/**","/images/**").permitAll()
			.antMatchers("/", "/search", "/signin", "/signup", "/signup-confirm").permitAll()
			.anyRequest().authenticated();

		// Login Screen
		http.formLogin().loginPage("/signin").successHandler(loginSuccessHandler).failureHandler(loginFailureHandler)
				.usernameParameter("username").passwordParameter("password").permitAll();

		// Logout Process
		http.logout().logoutSuccessUrl("/").logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
				.deleteCookies("JSESSIONID", "SESSION").invalidateHttpSession(true).permitAll();
	}

	/**
	 * 認証の設定
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 初期ユーザーの設定
		auth.userDetailsService(accountServiceImpl);
	}

}