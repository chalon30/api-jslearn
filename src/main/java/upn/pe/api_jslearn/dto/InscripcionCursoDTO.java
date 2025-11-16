package upn.pe.api_jslearn.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class InscripcionCursoDTO {

    private Long id;
    private Long usuarioId;
    private Long cursoId;
    private String estado;
    private LocalDateTime fechaInscripcion;
    private LocalDateTime fechaCompletado;
}
