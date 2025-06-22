package pe.upeu.edu.admin_panel.microservice_admin_panel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovimientoDTO {
    private Long id;
    private String tipoMovimiento;       // entrada o salida
    private Integer cantidad;
    private String motivo;
    private LocalDateTime fechaMovimiento;
    private String usuarioResponsable;
    private Long idInventario;
}
