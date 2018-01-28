package github.stuparm.marvin.marvinjava;

import github.stuparm.marvin.marvinjava.processor.ShellProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class MarvinJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarvinJavaApplication.class, args);
    }

    @Bean
    public ShellProcessor shellProcessor() {
        return new ShellProcessor();
    }

}
