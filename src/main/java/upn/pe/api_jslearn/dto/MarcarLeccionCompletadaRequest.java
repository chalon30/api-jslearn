package upn.pe.api_jslearn.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarcarLeccionCompletadaRequest {

    private Long usuarioId;
    private Long cursoId;
    private Long leccionId;
}
