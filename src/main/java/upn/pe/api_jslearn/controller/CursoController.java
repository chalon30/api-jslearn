package upn.pe.api_jslearn.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import upn.pe.api_jslearn.dto.CursoDTO;
import upn.pe.api_jslearn.service.CursoService;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CursoController {

    private final CursoService cursoService;

    @GetMapping
    public List<CursoDTO> getCursos() {
        return cursoService.listarCursosActivos();
    }

    @GetMapping("/{id}")
    public CursoDTO getCursoPorId(@PathVariable Long id) {
        return cursoService.obtenerCursoPorId(id);
    }

}
