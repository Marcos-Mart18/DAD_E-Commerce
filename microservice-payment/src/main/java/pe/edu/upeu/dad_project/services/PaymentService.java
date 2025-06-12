package pe.edu.upeu.dad_project.services;

import org.springframework.beans.factory.annotation.Value;
import pe.edu.upeu.dad_project.domain.Payment;
import pe.edu.upeu.dad_project.dto.ProductRequest;
import pe.edu.upeu.dad_project.dto.StripeResponse;


import java.util.List;
import java.util.Optional;

public interface PaymentService {
    @Value("${stripe.secretKey}")
 //   private String secretKey;

    Payment create(Payment payment);
    Payment update(Payment payment);
    void delete(Long id);
    Optional<Payment> getById(Long id);
    List<Payment> getAll();


}
