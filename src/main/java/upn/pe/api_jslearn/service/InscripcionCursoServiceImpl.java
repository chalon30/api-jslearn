package upn.pe.api_jslearn.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import upn.pe.api_jslearn.dto.InscripcionCursoDTO;
import upn.pe.api_jslearn.model.Curso;
import upn.pe.api_jslearn.model.InscripcionCurso;
import upn.pe.api_jslearn.model.Usuario;
import upn.pe.api_jslearn.repository.ICursoRepository;
import upn.pe.api_jslearn.repository.IInscripcionCursoRepository;
import upn.pe.api_jslearn.repository.IUsuarioRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InscripcionCursoServiceImpl implements InscripcionCursoService {

    private final IUsuarioRepository usuarioRepository;
    private final ICursoRepository cursoRepository;
    private final IInscripcionCursoRepository inscripcionCursoRepository;

    @Override
    @Transactional
    public InscripcionCursoDTO inscribirUsuarioEnCurso(Long usuarioId, Long cursoId) {

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        InscripcionCurso inscripcion = inscripcionCursoRepository
                .findByUsuarioIdAndCursoId(usuarioId, cursoId)
                .orElse(
                        InscripcionCurso.builder()
                                .usuario(usuario)
                                .curso(curso)
                                .build()
                );

        inscripcion.setEstado("ACTIVO");
        inscripcion.setFechaInscripcion(LocalDateTime.now());
        if ("COMPLETADO".equals(inscripcion.getEstado())) {
            inscripcion.setFechaCompletado(null);
        }

        InscripcionCurso guardada = inscripcionCursoRepository.save(inscripcion);

        return toDTO(guardada);
    }

    @Override
    @Transactional(readOnly = true)
    public List<InscripcionCursoDTO> listarInscripcionesPorUsuario(Long usuarioId) {

        return inscripcionCursoRepository.findByUsuarioId(usuarioId).stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<InscripcionCursoDTO> listarInscripcionesPorCurso(Long cursoId) {

        return inscripcionCursoRepository.findByCursoId(cursoId).stream()
                .map(this::toDTO)
                .toList();
    }

    private InscripcionCursoDTO toDTO(InscripcionCurso inscripcion) {
        return InscripcionCursoDTO.builder()
                .id(inscripcion.getId())
                .usuarioId(inscripcion.getUsuario().getId())
                .cursoId(inscripcion.getCurso().getId())
                .estado(inscripcion.getEstado())
                .fechaInscripcion(inscripcion.getFechaInscripcion())
                .fechaCompletado(inscripcion.getFechaCompletado())
                .build();
    }
}
