package upn.pe.api_jslearn.dto;

import java.util.List;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeccionDTO {

    private Long id;
    private String titulo;
    private String contenido;
    private String videoUrl;

    private String intro1;
    private String intro2;
    private String intro3;

    private Integer numeroOrden;

    private List<PreguntaDTO> preguntas;
}
