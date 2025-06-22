package pe.upeu.edu.admin_panel.microservice_admin_panel.service;

import pe.upeu.edu.admin_panel.microservice_admin_panel.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
    List<PaymentDTO> getAll();
    PaymentDTO getById(Long id);
}
