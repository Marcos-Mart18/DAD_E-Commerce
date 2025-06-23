package pe.edu.upeu.dad_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DadProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DadProjectApplication.class, args);
    }

}
