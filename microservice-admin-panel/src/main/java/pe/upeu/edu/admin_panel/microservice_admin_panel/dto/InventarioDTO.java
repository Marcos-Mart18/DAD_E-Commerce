package pe.upeu.edu.admin_panel.microservice_admin_panel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InventarioDTO {
    private Long id;
    private Integer stockDisponible;
    private Integer stockReservado;
    private Integer stockMinimo;
    private String ubicacion;
    private LocalDateTime fechaActualizacion;
    private String estado;
    private Long idProducto;
}
