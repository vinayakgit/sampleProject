package com.sample.SampleProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@ComponentScan("com.sample")
@RestController
@EnableAutoConfiguration
@EnableJpaRepositories("com.sample")
@PropertySource("application.properties")
public class App 
{
    public static void main( String[] args )
    {
    	
        SpringApplication.run(App.class, args);
    }
    
   /* @RequestMapping(value="/")
    String home(){
    	return "Spring";
    }*/
}
