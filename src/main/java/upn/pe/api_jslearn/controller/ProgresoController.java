package upn.pe.api_jslearn.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import upn.pe.api_jslearn.dto.MarcarLeccionCompletadaRequest;
import upn.pe.api_jslearn.dto.ProgresoCursoDTO;
import upn.pe.api_jslearn.dto.RespuestaPreguntaDTO;
import upn.pe.api_jslearn.model.RespuestaPregunta;
import upn.pe.api_jslearn.repository.IRespuestaPreguntaRepository;
import upn.pe.api_jslearn.service.ProgresoService;

import java.util.List;

@RestController
@RequestMapping("/api/progreso")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProgresoController {

    private final ProgresoService progresoService;
    private final IRespuestaPreguntaRepository respuestaPreguntaRepository;

    // -------------------------------
    // 1. Marcar lección completada
    // -------------------------------
    @PostMapping("/leccion-completada")
    public ProgresoCursoDTO marcarLeccionCompletada(@RequestBody MarcarLeccionCompletadaRequest request) {

        return progresoService.marcarLeccionCompletada(
                request.getUsuarioId(),
                request.getCursoId(),
                request.getLeccionId(),
                request.getRespuestas()
        );
    }

    // -------------------------------
    // 2. Obtener progreso de un curso
    // -------------------------------
    @GetMapping("/{cursoId}")
    public ProgresoCursoDTO obtenerProgreso(
            @PathVariable Long cursoId,
            @RequestParam Long usuarioId
    ) {
        return progresoService.obtenerProgresoCurso(usuarioId, cursoId);
    }

    // -------------------------------
    // 3. Obtener progreso de TODOS los cursos del usuario
    // -------------------------------
    @GetMapping("/usuario/{usuarioId}")
    public List<ProgresoCursoDTO> obtenerProgresoPorUsuario(@PathVariable Long usuarioId) {
        return progresoService.obtenerProgresoPorUsuario(usuarioId);
    }

    // -------------------------------
    // 4. Obtener respuestas del usuario por lección (DTO)
    // -------------------------------
    @GetMapping("/respuestas/{usuarioId}/{leccionId}")
    public List<RespuestaPreguntaDTO> getRespuestas(
            @PathVariable Long usuarioId,
            @PathVariable Long leccionId
    ) {
        List<RespuestaPregunta> respuestas = respuestaPreguntaRepository
                .findByUsuarioIdAndLeccionId(usuarioId, leccionId);

        return respuestas.stream().map(r -> {
            RespuestaPreguntaDTO dto = new RespuestaPreguntaDTO();
            dto.setId(r.getId());
            dto.setPreguntaId(r.getPregunta().getId());
            dto.setOpcionSeleccionadaId(r.getOpcionSeleccionada().getId());
            dto.setCorrecta(r.isCorrecta());
            dto.setFechaRespuesta(r.getFechaRespuesta());
            return dto;
        }).toList();
    }
}
