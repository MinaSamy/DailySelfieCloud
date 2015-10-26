package bloodstone.dailyselfie.cloud;

import javax.servlet.Servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

import bloodstone.dailyselfie.cloud.servlets.TestServlet;

@SpringBootApplication
public class DailySelfieCloudApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DailySelfieCloudApplication.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    	
    	return builder.sources(DailySelfieCloudApplication.class);
    }
    
    
    @Bean
    public Servlet dispatcherServlet(){
    	return new TestServlet();
    }
}
