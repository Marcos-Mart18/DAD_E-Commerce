package pe.upeu.edu.shipping.dto;

import lombok.*;
import pe.upeu.edu.shipping.entities.ShippingAddress;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ShippingRequestDto {
    private Long orderId;
    private String carrier;
    private String shippingMethod;
    private ShippingAddress address;
}
