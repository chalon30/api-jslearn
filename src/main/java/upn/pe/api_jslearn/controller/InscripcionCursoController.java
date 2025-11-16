package upn.pe.api_jslearn.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import upn.pe.api_jslearn.dto.InscripcionCursoDTO;
import upn.pe.api_jslearn.dto.InscripcionCursoRequest;
import upn.pe.api_jslearn.service.InscripcionCursoService;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class InscripcionCursoController {

    private final InscripcionCursoService inscripcionCursoService;

    @PostMapping("/{cursoId}/inscribirme")
    public InscripcionCursoDTO inscribirmeEnCurso(
            @PathVariable Long cursoId,
            @RequestBody InscripcionCursoRequest request
    ) {
        return inscripcionCursoService.inscribirUsuarioEnCurso(
                request.getUsuarioId(),
                cursoId
        );
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<InscripcionCursoDTO> obtenerCursosInscritosPorUsuario(
            @PathVariable Long usuarioId
    ) {
        return inscripcionCursoService.listarInscripcionesPorUsuario(usuarioId);
    }

    @GetMapping("/curso/{cursoId}")
    public List<InscripcionCursoDTO> obtenerInscritosPorCurso(
            @PathVariable Long cursoId
    ) {
        return inscripcionCursoService.listarInscripcionesPorCurso(cursoId);
    }
}
