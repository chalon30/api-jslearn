package upn.pe.api_jslearn.controller;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import upn.pe.api_jslearn.dto.MarcarLeccionCompletadaRequest;
import upn.pe.api_jslearn.dto.ProgresoCursoDTO;
import upn.pe.api_jslearn.service.ProgresoService;

@RestController
@RequestMapping("/api/progreso")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProgresoController {

    private final ProgresoService progresoService;

    @PostMapping("/leccion-completada")
    public ProgresoCursoDTO marcarLeccionCompletada(@RequestBody MarcarLeccionCompletadaRequest request) {
        return progresoService.marcarLeccionCompletada(
                request.getUsuarioId(),
                request.getCursoId(),
                request.getLeccionId()
        );
    }

    @GetMapping("/{cursoId}")
    public ProgresoCursoDTO obtenerProgreso(
            @PathVariable Long cursoId,
            @RequestParam Long usuarioId
    ) {
        return progresoService.obtenerProgresoCurso(usuarioId, cursoId);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<ProgresoCursoDTO> obtenerProgresoPorUsuario(@PathVariable Long usuarioId) {
        return progresoService.obtenerProgresoPorUsuario(usuarioId);
    }
}
