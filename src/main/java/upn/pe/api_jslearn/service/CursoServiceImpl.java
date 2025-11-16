package upn.pe.api_jslearn.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import upn.pe.api_jslearn.dto.CursoDTO;
import upn.pe.api_jslearn.mapper.CursoMapper;

import upn.pe.api_jslearn.repository.ICursoRepository;

import java.util.List;


import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {

    private final ICursoRepository cursoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CursoDTO> listarCursosActivos() {
        var cursos = cursoRepository.findByActivoTrue();
        return cursos.stream()
                .map(CursoMapper::toCursoDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CursoDTO obtenerCursoPorId(Long id) {
        var curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con id: " + id));

        // Dentro de la transacción, al mapear el DTO se inicializan
        // modulos y lecciones sin problemas (con varias consultas, pero sin el error).
        return CursoMapper.toCursoDTO(curso);
    }
}
