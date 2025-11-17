package upn.pe.api_jslearn.dto;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataDTO {

    private List<CursoDTO> cursos;
    private List<ModuloDTO> modulos;
    private List<LeccionDTO> lecciones;
    private List<PreguntaDTO> preguntas;
    private List<OpcionDTO> opciones;
}
