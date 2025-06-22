package pe.upeu.edu.admin_panel.microservice_admin_panel.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductoDTO {
    private Long id;
    private String name;
    private String description;
    private double price;
    private CategoriaDTO category;
}
