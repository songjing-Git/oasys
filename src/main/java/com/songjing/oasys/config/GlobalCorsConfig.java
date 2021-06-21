package com.songjing.oasys.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author songjing
 * @version 1.0
 * @date 2020/12/23 10:02
 */
@Configuration
@Slf4j
public class GlobalCorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        log.info("添加CORS配置信息");
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:8081");
        //config.addAllowedOrigin("http://localhost:8081");
        //2) 是否发送Cookie信息
        config.setAllowCredentials(true);
        log.info("添加跨域允许的请求方式");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");

        config.addAllowedHeader("*");
        log.info("添加映射路径，我们拦截一切请求");
        UrlBasedCorsConfigurationSource configSource = new
                UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);
        log.info("跨域设置成功");

        //3.返回新的CorsFilter.
        return new CorsFilter(configSource);
    }
}
