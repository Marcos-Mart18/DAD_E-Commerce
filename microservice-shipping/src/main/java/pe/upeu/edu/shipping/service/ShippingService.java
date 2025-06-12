package pe.upeu.edu.shipping.service;

import pe.upeu.edu.shipping.dto.ShippingRequestDto;
import pe.upeu.edu.shipping.entities.Shipping;

import java.util.List;

public interface ShippingService {
    Shipping createShipping(ShippingRequestDto dto);
    Shipping getShippingById(Long id);
    Shipping getShippingByOrderId(Long orderId);
    Shipping updateStatus(Long id, String status);
    List<Shipping> getAllShippings();
}
