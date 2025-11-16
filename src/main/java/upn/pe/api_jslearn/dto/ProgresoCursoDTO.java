package upn.pe.api_jslearn.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProgresoCursoDTO {
    private Long cursoId;
    private Long usuarioId;
    private int porcentaje;
    private int leccionesCompletadas;
    private int totalLecciones;
    private Long ultimaLeccionId;
    private String ultimaLeccionTitulo;
    private boolean cursoCompletado;
    private List<Long> leccionesCompletadasIds;
}
