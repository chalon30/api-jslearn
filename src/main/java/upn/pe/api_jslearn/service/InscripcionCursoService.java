package upn.pe.api_jslearn.service;

import upn.pe.api_jslearn.dto.InscripcionCursoDTO;

import java.util.List;

public interface InscripcionCursoService {

    InscripcionCursoDTO inscribirUsuarioEnCurso(Long usuarioId, Long cursoId);

    List<InscripcionCursoDTO> listarInscripcionesPorUsuario(Long usuarioId);

    List<InscripcionCursoDTO> listarInscripcionesPorCurso(Long cursoId);
}
