package pe.edu.upeu.microservice_notification.api.dto;

import lombok.Data;

@Data
public class PersonaDto {
    private Long idPersona;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String dni;
    private char isActive;

}
