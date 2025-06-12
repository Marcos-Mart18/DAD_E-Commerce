package pe.edu.upeu.dad_project.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.dad_project.domain.Invoice;
import pe.edu.upeu.dad_project.domain.Payment;
import pe.edu.upeu.dad_project.repository.InvoiceRepository;
import pe.edu.upeu.dad_project.repository.PaymentRepository;
import pe.edu.upeu.dad_project.services.InvoiceService;
import pe.edu.upeu.dad_project.services.PaymentService;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public Invoice create(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice update(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public void delete(Long id) {
        invoiceRepository.deleteById(id);
    }

    @Override
    public Optional<Invoice> getById(Long id) {
        return invoiceRepository.findById(id);
    }

    @Override
    public List<Invoice> getAll() {
        return invoiceRepository.findAll();
    }
    }
