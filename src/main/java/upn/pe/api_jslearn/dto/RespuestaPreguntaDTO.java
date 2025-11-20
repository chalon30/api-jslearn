package upn.pe.api_jslearn.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaPreguntaDTO {

    private Long id;
    private Long preguntaId;
    private Long opcionSeleccionadaId;
    private boolean correcta;
    private LocalDateTime fechaRespuesta;
}
