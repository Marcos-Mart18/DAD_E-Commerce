package pe.upeu.edu.admin_panel.microservice_admin_panel.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.upeu.edu.admin_panel.microservice_admin_panel.client.PaymentClient;
import pe.upeu.edu.admin_panel.microservice_admin_panel.dto.PaymentDTO;
import pe.upeu.edu.admin_panel.microservice_admin_panel.service.PaymentService;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    public final PaymentClient paymentClient;

    @Override
    public List<PaymentDTO> getAll() {
        ResponseEntity<List<PaymentDTO>> response = paymentClient.getAllForAdmin();
        if (response.getStatusCode() == HttpStatus.NO_CONTENT) {
            return new ArrayList<>();
        }
        return response.getBody();
    }

    @Override
    public PaymentDTO getById(Long id) {
        return paymentClient.getByIdForAdmin(id);
    }
}
