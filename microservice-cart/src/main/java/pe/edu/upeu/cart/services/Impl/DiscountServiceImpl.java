package pe.edu.upeu.cart.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.cart.domain.Discount;
import pe.edu.upeu.cart.repository.DiscountRepository;
import pe.edu.upeu.cart.services.DiscountService;

import java.util.List;
import java.util.Optional;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    public DiscountRepository discountRepository;

    @Override
    public Discount create(Discount discount) {
        return discountRepository.save(discount);
    }

    @Override
    public Discount update(Discount discount) {
        return discountRepository.save(discount);
    }

    @Override
    public void delete(Long id) {discountRepository.deleteById(id);}

    @Override
    public Optional<Discount> getById(Long id) {
        return discountRepository.findById(id);
    }

    @Override
    public List<Discount> getAll() {
        return discountRepository.findAll();
    }

}
