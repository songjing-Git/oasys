package com.songjing.oasys.config;

/**
 * @author songjing
 * @version 1.0
 * @date 2021/3/9 16:27
 */
/*@Configuration*/
public class SecurityConfig  {
//    extends WebSecurityConfigurerAdapter

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //下面这两行配置表示在内存中配置了两个用户
        auth.inMemoryAuthentication()
                .withUser("javaboy")
                .roles("admin").
                password("$2a$10$OR3VSksVAmCzc.7WeaRPR.t0wyCsIj24k0Bne8iKWV1o.V9wsP8Xe")
                .and()
                .withUser("lisi")
                .roles("user")
                .password("$2a$10$p1H8iWa8I4.CA.7Z8bwLjes91ZpY.rYREGHQEInNtAp4NzL6PLKxi");
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/
}
