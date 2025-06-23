package pe.upeu.edu.admin_panel.microservice_admin_panel.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.upeu.edu.admin_panel.microservice_admin_panel.dto.PaymentDTO;

import java.util.List;

@FeignClient(name = "msvc-payment", contextId = "payment-Client", path = "/payment")
public interface PaymentClient {
    @GetMapping("/admin")
    ResponseEntity<List<PaymentDTO>> getAllForAdmin();

    @GetMapping("/admin/{id}")
    PaymentDTO getByIdForAdmin(@PathVariable("id") Long id);
}
