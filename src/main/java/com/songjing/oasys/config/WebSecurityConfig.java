package com.songjing.oasys.config;

import com.songjing.oasys.security.handle.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;


/**
 * @author songjing
 * @version 1.0
 * @date 2021/4/28 14:32
 */


@Configuration
@Slf4j
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;


    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Autowired
    private MyAuthenticationEntryPoint myAuthenticationEntryPoint;


    @Autowired
    private MyAccessDeniedHandler myAccessDeniedHandler;


    @Autowired
    private MyExpiredSessionStrategy myExpiredSessionStrategy;

    /**
     * session过期(超时)处理方案
     */
    @Autowired
    private MyInvalidSessionStrategy myInvalidSessionStrategy;

    @Autowired
    private DataSource dataSource;

    @Bean
      public PersistentTokenRepository persistentTokenRepository(){
                JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
                 tokenRepository.setDataSource(dataSource);
        //系统在启动的时候生成“记住我”的数据表（只能使用一次）
                 tokenRepository.setCreateTableOnStartup(false);
                 return tokenRepository;
             }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        log.info("AuthenticationManagerBuilder 配置");
        auth.userDetailsService(userDetailsService)
        .passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //放在跨站请求伪造
        http.csrf().disable();
        //开启跨域
        http.cors();
        log.info("HttpSecurity 配置...");
        http.authorizeRequests()
                .antMatchers("/getCodeImg/**","/performance/performanceList","/pushSend").permitAll()
                .antMatchers(
                        HttpMethod.GET,
                        "/*.html",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js"
                ).permitAll()
                .antMatchers("/profile/**").permitAll()
                .antMatchers("/common/download**").permitAll()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/*/api-docs").permitAll()
                .antMatchers("/druid/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(myAuthenticationFailureHandler)
                .and()
                .rememberMe()
                .rememberMeParameter("remember-me")
                //对记住我进行设置
                .tokenRepository(persistentTokenRepository())
                //设置Token的有效时间
                .tokenValiditySeconds(1000)
                .and()
                .exceptionHandling()
                /*.accessDeniedHandler(myAccessDeniedHandler)
                .authenticationEntryPoint(myAuthenticationEntryPoint)*/
                .and()
                //无状态的,任何时候都不会使用session
                .sessionManagement()
                .invalidSessionStrategy(myInvalidSessionStrategy)
                .maximumSessions(1)
                .maxSessionsPreventsLogin(false)
                //.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                .expiredSessionStrategy(myExpiredSessionStrategy);



    }

}
