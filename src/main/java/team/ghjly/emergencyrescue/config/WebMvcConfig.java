package team.ghjly.emergencyrescue.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import team.ghjly.emergencyrescue.config.interceptor.AdminInterceptor;
import team.ghjly.emergencyrescue.config.interceptor.UserInterceptor;

import javax.annotation.Resource;
import java.time.format.DateTimeFormatter;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Resource
    private UserInterceptor userInterceptor;
    @Resource
    private AdminInterceptor adminInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOriginPatterns("*").allowedHeaders("*").allowedMethods("*").allowCredentials(true);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterceptor).addPathPatterns("/user/vip/**");
        registry.addInterceptor(adminInterceptor).addPathPatterns("/admin/vip/**");
    }

    @Bean
    public DateTimeFormatter dateTimeFormatter() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
