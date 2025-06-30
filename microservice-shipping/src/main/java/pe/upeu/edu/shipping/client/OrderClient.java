package pe.upeu.edu.shipping.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-order", url = "http://localhost:8092")
public interface OrderClient {
    @GetMapping("/orders/{id}")
    Object getOrderById(@PathVariable("id") Long id);
}
