package pe.upeu.edu.shipping.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upeu.edu.shipping.client.OrderClient;
import pe.upeu.edu.shipping.dto.ShippingRequestDto;
import pe.upeu.edu.shipping.entities.Shipping;
import pe.upeu.edu.shipping.entities.ShippingAddress;
import pe.upeu.edu.shipping.repository.ShippingRepository;
import pe.upeu.edu.shipping.service.ShippingService;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class ShippingServiceImpl implements ShippingService {
    @Autowired
    private ShippingRepository shippingRepository;

    @Autowired
    private OrderClient orderClient;

    @Override
    public Shipping createShipping(ShippingRequestDto dto) {
        Shipping shipping = new Shipping();
        shipping.setOrderId(dto.getOrderId());
        shipping.setCarrier(dto.getCarrier());
        shipping.setShippingMethod(dto.getShippingMethod());
        shipping.setStatus("PENDING");
        shipping.setShippedAt(LocalDateTime.now());

        ShippingAddress address = new ShippingAddress();
        address.setCountry(dto.getAddress().getCountry());
        address.setRegion(dto.getAddress().getRegion());
        address.setCity(dto.getAddress().getCity());
        address.setPostalCode(dto.getAddress().getPostalCode());
        address.setStreet(dto.getAddress().getStreet());
        shipping.setAddress(address);

        return shippingRepository.save(shipping);
    }

    @Override
    public Shipping getShippingById(Long id) {
        return shippingRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Shipping not found"));
    }

    @Override
    public Shipping getShippingByOrderId(Long orderId) {
        return shippingRepository.findByOrderId(orderId)
                .orElseThrow(() -> new RuntimeException("Shipping for order not found"));
    }

    @Override
    public Shipping updateStatus(Long id, String status) {
        Shipping shipping = getShippingById(id);
        shipping.setStatus(status);
        return shippingRepository.save(shipping);
    }

    @Override
    public List<Shipping> getAllShippings() {
        return shippingRepository.findAll();
    }
}
