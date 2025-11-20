package upn.pe.api_jslearn.service;

import upn.pe.api_jslearn.dto.ProgresoCursoDTO;
import upn.pe.api_jslearn.dto.PreguntaRespuestaDTO;

import java.util.List;

public interface ProgresoService {

    ProgresoCursoDTO marcarLeccionCompletada(
            Long usuarioId,
            Long cursoId,
            Long leccionId,
            List<PreguntaRespuestaDTO> respuestas
    );

    ProgresoCursoDTO obtenerProgresoCurso(Long usuarioId, Long cursoId);

    List<ProgresoCursoDTO> obtenerProgresoPorUsuario(Long usuarioId);
}
