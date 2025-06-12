package pe.edu.upeu.cart.services;

import org.springframework.stereotype.Service;
import pe.edu.upeu.cart.domain.Discount;

import java.util.List;
import java.util.Optional;

public interface DiscountService {
    Discount create(Discount discount);
    Discount update(Discount discount);
    void delete(Long id);
    Optional<Discount> getById(Long id);
    List<Discount> getAll();
}
