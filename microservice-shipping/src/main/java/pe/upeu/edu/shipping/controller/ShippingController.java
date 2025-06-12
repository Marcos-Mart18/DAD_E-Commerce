package pe.upeu.edu.shipping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upeu.edu.shipping.dto.ShippingRequestDto;
import pe.upeu.edu.shipping.dto.UpdateStatusDto;
import pe.upeu.edu.shipping.entities.Shipping;
import pe.upeu.edu.shipping.service.ShippingService;

import java.util.List;

@RestController
@RequestMapping("/api/shippings")
public class ShippingController {
    @Autowired
    private ShippingService shippingService;

    @PostMapping
    public ResponseEntity<Shipping> createShipping(@RequestBody ShippingRequestDto dto) {
        Shipping shipping = shippingService.createShipping(dto);
        return ResponseEntity.ok(shipping);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shipping> getShippingById(@PathVariable Long id) {
        Shipping shipping = shippingService.getShippingById(id);
        return ResponseEntity.ok(shipping);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<Shipping> getShippingByOrderId(@PathVariable Long orderId) {
        Shipping shipping = shippingService.getShippingByOrderId(orderId);
        return ResponseEntity.ok(shipping);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Shipping> updateStatus(@PathVariable Long id, @RequestBody UpdateStatusDto dto) {
        Shipping shipping = shippingService.updateStatus(id, dto.getStatus());
        return ResponseEntity.ok(shipping);
    }

    @GetMapping
    public ResponseEntity<List<Shipping>> getAllShippings() {
        List<Shipping> list = shippingService.getAllShippings();
        return ResponseEntity.ok(list);
    }
}
