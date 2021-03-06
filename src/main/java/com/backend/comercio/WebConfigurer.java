package com.backend.comercio;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@ComponentScan
public class WebConfigurer implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry.addResourceHandler("/img/**").addResourceLocations("file://" + System.getProperty("user.dir") + "/src/main/img/");
    	registry.addResourceHandler("/imgqr/**").addResourceLocations("file://" + System.getProperty("user.dir") + "/src/main/imgqr/");
    	registry.addResourceHandler("/imgfront/**").addResourceLocations("file://" + System.getProperty("user.dir") + "/src/main/imgfront/");
    }
}
