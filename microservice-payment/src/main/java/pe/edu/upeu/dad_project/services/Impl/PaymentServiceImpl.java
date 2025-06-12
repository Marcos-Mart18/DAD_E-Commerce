package pe.edu.upeu.dad_project.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.dad_project.domain.Payment;
import pe.edu.upeu.dad_project.dto.ProductRequest;
import pe.edu.upeu.dad_project.dto.StripeResponse;
import pe.edu.upeu.dad_project.repository.PaymentRepository;
import pe.edu.upeu.dad_project.services.PaymentService;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment update(Payment persona) {
        return paymentRepository.save(persona);
    }

    @Override
    public void delete(Long id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public Optional<Payment> getById(Long id) {
        return paymentRepository.findById(id);
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }


    }
