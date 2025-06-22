package pe.upeu.edu.admin_panel.microservice_admin_panel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceAdminPanelApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceAdminPanelApplication.class, args);
	}

}
