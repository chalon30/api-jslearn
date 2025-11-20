// dto
package upn.pe.api_jslearn.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarcarLeccionCompletadaRequest {
    private Long usuarioId;
    private Long cursoId;
    private Long leccionId;
    private List<PreguntaRespuestaDTO> respuestas; // 👈 nuevo
}
