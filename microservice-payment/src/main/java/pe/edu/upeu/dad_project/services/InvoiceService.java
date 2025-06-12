package pe.edu.upeu.dad_project.services;

import pe.edu.upeu.dad_project.domain.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {
    Invoice create(Invoice invoice);
    Invoice update(Invoice invoice);
    void delete(Long id);
    Optional<Invoice> getById(Long id);
    List<Invoice> getAll();
}
