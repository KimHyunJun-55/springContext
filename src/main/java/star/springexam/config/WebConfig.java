package star.springexam.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//스프링설정
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    public WebConfig() {
        System.out.println("WebConfig()");
    }
}
