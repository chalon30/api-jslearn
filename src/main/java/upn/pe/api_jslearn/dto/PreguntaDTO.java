package upn.pe.api_jslearn.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PreguntaDTO {

    private Long id;
    private String enunciado;
    private String explicacion;
    private Integer numeroOrden;

    private List<OpcionDTO> opciones;
}
