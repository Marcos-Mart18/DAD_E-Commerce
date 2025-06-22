package pe.upeu.edu.admin_panel.microservice_admin_panel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentDTO {
    private Long id;
    private double monto;
    private String estado;
    private String fecha;
    private String errorMessage;
    private String methodName;
    private Long invoiceId;
}
