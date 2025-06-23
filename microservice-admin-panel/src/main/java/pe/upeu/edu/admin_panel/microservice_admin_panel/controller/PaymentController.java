package pe.upeu.edu.admin_panel.microservice_admin_panel.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.upeu.edu.admin_panel.microservice_admin_panel.dto.PaymentDTO;
import pe.upeu.edu.admin_panel.microservice_admin_panel.service.PaymentService;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/admin/pagos")
@RequiredArgsConstructor
public class PaymentController {
    public final PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<PaymentDTO>> findAll() {
        List<PaymentDTO> pagos = paymentService.getAll();
        if (pagos == null || pagos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pagos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDTO> findById(@PathVariable Long id) {
        PaymentDTO pago = paymentService.getById(id);
        if (pago != null) {
            return new ResponseEntity<>(pago, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
