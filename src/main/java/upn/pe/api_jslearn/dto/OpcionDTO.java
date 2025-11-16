package upn.pe.api_jslearn.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OpcionDTO {

    private Long id;
    private String texto;
    private boolean correcta;
    private Integer numeroOrden;
}
