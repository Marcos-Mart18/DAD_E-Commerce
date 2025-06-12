package pe.upeu.edu.shipping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class MicroserviceShippingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceShippingApplication.class, args);
	}

}
