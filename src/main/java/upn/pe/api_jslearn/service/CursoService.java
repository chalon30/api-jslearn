package upn.pe.api_jslearn.service;

import upn.pe.api_jslearn.dto.CursoDTO;

import java.util.List;

public interface CursoService {

    List<CursoDTO> listarCursosActivos();

    CursoDTO obtenerCursoPorId(Long id);
}
