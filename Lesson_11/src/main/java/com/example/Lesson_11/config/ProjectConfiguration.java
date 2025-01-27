package com.example.Lesson_11.config;





import com.example.Lesson_11.aspects.LoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "org.example")
@EnableAspectJAutoProxy
public class ProjectConfiguration {
    @Bean
    public LoggingAspect aspect() {
        return new LoggingAspect();
    }
}
