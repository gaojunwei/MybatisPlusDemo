package com.go.demo.config;

import com.go.demo.config.intercepter.MDCInterceptor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 系统配置文件
 */
@Configuration
@Setter
@Getter
public class WebMvcConfig extends WebMvcConfigurationSupport {

    /**
     * 添加自定义拦截器
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MDCInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
