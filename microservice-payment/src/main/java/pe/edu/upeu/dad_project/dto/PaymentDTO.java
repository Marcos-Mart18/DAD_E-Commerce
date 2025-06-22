package pe.edu.upeu.dad_project.dto;

import lombok.Data;

@Data
public class PaymentDTO {
    private Long id;
    private double monto;
    private String estado;
    private String fecha;
    private String errorMessage;
    private String methodName;
    private Long invoiceId;
}
