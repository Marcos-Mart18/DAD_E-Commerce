package pe.upeu.edu.inventory.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.upeu.edu.inventory.dto.ProductDTO;

@FeignClient(name = "msvc-catalog")
public interface ProductClient {
    @GetMapping("/products/{id}")
    ProductDTO getProductById(@PathVariable("id") Long id);

}
