package upn.pe.api_jslearn.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import upn.pe.api_jslearn.dto.ProgresoCursoDTO;
import upn.pe.api_jslearn.model.*;
import upn.pe.api_jslearn.repository.*;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgresoServiceImpl implements ProgresoService {

    private final IUsuarioRepository usuarioRepository;
    private final ICursoRepository cursoRepository;
    private final ILeccionRepository leccionRepository;
    private final IProgresoLeccionRepository progresoLeccionRepository;
    private final IProgresoCursoRepository progresoCursoRepository;
    private final IInscripcionCursoRepository inscripcionCursoRepository; // 👈 nuevo

    @Override
    @Transactional
    public ProgresoCursoDTO marcarLeccionCompletada(Long usuarioId, Long cursoId, Long leccionId) {

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        Leccion leccion = leccionRepository.findById(leccionId)
                .orElseThrow(() -> new RuntimeException("Lección no encontrada"));

        if (!leccion.getModulo().getCurso().getId().equals(cursoId)) {
            throw new RuntimeException("La lección no pertenece al curso indicado");
        }

        // 🔒 Validar que el usuario esté inscrito en el curso
        inscripcionCursoRepository.findByUsuarioIdAndCursoId(usuarioId, cursoId)
                .orElseThrow(() -> new RuntimeException("El usuario no está inscrito en este curso"));

        ProgresoLeccion progresoLeccion = progresoLeccionRepository
                .findByUsuarioIdAndLeccionId(usuarioId, leccionId)
                .orElse(
                        ProgresoLeccion.builder()
                                .usuario(usuario)
                                .leccion(leccion)
                                .build()
                );

        progresoLeccion.setCompletada(true);
        progresoLeccion.setFechaCompletada(LocalDateTime.now());

        progresoLeccionRepository.save(progresoLeccion);

        List<ProgresoLeccion> progresosDelCurso = progresoLeccionRepository
                .findByUsuarioIdAndLeccion_Modulo_Curso_Id(usuarioId, cursoId);

        long leccionesCompletadas = progresosDelCurso.stream()
                .filter(ProgresoLeccion::isCompletada)
                .count();

        int totalLecciones = curso.getModulos().stream()
                .mapToInt(m -> m.getLecciones().size())
                .sum();

        int porcentaje = 0;
        if (totalLecciones > 0) {
            porcentaje = (int) Math.round((leccionesCompletadas * 100.0) / totalLecciones);
        }

        boolean cursoCompletado = (totalLecciones > 0 && leccionesCompletadas == totalLecciones);

        ProgresoCurso progresoCurso = progresoCursoRepository
                .findByUsuarioIdAndCursoId(usuarioId, cursoId)
                .orElse(
                        ProgresoCurso.builder()
                                .usuario(usuario)
                                .curso(curso)
                                .build()
                );

        progresoCurso.setPorcentaje(porcentaje);
        progresoCurso.setUltimaLeccion(leccion);
        progresoCurso.setFechaUltimaActividad(LocalDateTime.now());

        progresoCursoRepository.save(progresoCurso);

        var leccionesCompletadasIds = progresosDelCurso.stream()
                .filter(ProgresoLeccion::isCompletada)
                .map(pl -> pl.getLeccion().getId())
                .toList();

        return ProgresoCursoDTO.builder()
                .cursoId(cursoId)
                .usuarioId(usuarioId)
                .porcentaje(porcentaje)
                .leccionesCompletadas((int) leccionesCompletadas)
                .totalLecciones(totalLecciones)
                .ultimaLeccionId(leccion.getId())
                .ultimaLeccionTitulo(leccion.getTitulo())
                .cursoCompletado(cursoCompletado)
                .leccionesCompletadasIds(leccionesCompletadasIds)
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public ProgresoCursoDTO obtenerProgresoCurso(Long usuarioId, Long cursoId) {

        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        int totalLecciones = curso.getModulos().stream()
                .mapToInt(m -> m.getLecciones().size())
                .sum();

        List<ProgresoLeccion> progresosDelCurso = progresoLeccionRepository
                .findByUsuarioIdAndLeccion_Modulo_Curso_Id(usuarioId, cursoId);

        long leccionesCompletadas = progresosDelCurso.stream()
                .filter(ProgresoLeccion::isCompletada)
                .count();

        int porcentaje = 0;
        if (totalLecciones > 0) {
            porcentaje = (int) Math.round((leccionesCompletadas * 100.0) / totalLecciones);
        }

        boolean cursoCompletado = (totalLecciones > 0 && leccionesCompletadas == totalLecciones);

        ProgresoCurso progresoCurso = progresoCursoRepository
                .findByUsuarioIdAndCursoId(usuarioId, cursoId)
                .orElse(null);

        Long ultimaLeccionId = null;
        String ultimaLeccionTitulo = null;

        if (progresoCurso != null && progresoCurso.getUltimaLeccion() != null) {
            ultimaLeccionId = progresoCurso.getUltimaLeccion().getId();
            ultimaLeccionTitulo = progresoCurso.getUltimaLeccion().getTitulo();
        }

        var leccionesCompletadasIds = progresosDelCurso.stream()
                .filter(ProgresoLeccion::isCompletada)
                .map(pl -> pl.getLeccion().getId())
                .toList();

        return ProgresoCursoDTO.builder()
                .cursoId(cursoId)
                .usuarioId(usuarioId)
                .porcentaje(porcentaje)
                .leccionesCompletadas((int) leccionesCompletadas)
                .totalLecciones(totalLecciones)
                .ultimaLeccionId(ultimaLeccionId)
                .ultimaLeccionTitulo(ultimaLeccionTitulo)
                .cursoCompletado(cursoCompletado)
                .leccionesCompletadasIds(leccionesCompletadasIds)
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProgresoCursoDTO> obtenerProgresoPorUsuario(Long usuarioId) {

        var progresos = progresoCursoRepository.findByUsuarioId(usuarioId);

        return progresos.stream()
                .map(pc -> {

                    int totalLecciones = pc.getCurso().getModulos().stream()
                            .mapToInt(m -> m.getLecciones().size())
                            .sum();

                    var progresosDelCurso = progresoLeccionRepository
                            .findByUsuarioIdAndLeccion_Modulo_Curso_Id(
                                    usuarioId,
                                    pc.getCurso().getId()
                            );

                    long leccionesCompletadas = progresosDelCurso.stream()
                            .filter(ProgresoLeccion::isCompletada)
                            .count();

                    boolean cursoCompletado = (totalLecciones > 0 && leccionesCompletadas == totalLecciones);

                    var leccionesCompletadasIds = progresosDelCurso.stream()
                            .filter(ProgresoLeccion::isCompletada)
                            .map(pl -> pl.getLeccion().getId())
                            .toList();

                    return ProgresoCursoDTO.builder()
                            .cursoId(pc.getCurso().getId())
                            .usuarioId(pc.getUsuario().getId())
                            .porcentaje(pc.getPorcentaje())
                            .leccionesCompletadas((int) leccionesCompletadas)
                            .totalLecciones(totalLecciones)
                            .ultimaLeccionId(
                                    pc.getUltimaLeccion() != null ? pc.getUltimaLeccion().getId() : null
                            )
                            .ultimaLeccionTitulo(
                                    pc.getUltimaLeccion() != null ? pc.getUltimaLeccion().getTitulo() : null
                            )
                            .cursoCompletado(cursoCompletado)
                            .leccionesCompletadasIds(leccionesCompletadasIds)
                            .build();
                })
                .toList();
    }
}
