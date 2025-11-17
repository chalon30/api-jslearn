package upn.pe.api_jslearn.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upn.pe.api_jslearn.dto.DataDTO;
import upn.pe.api_jslearn.model.*;
import upn.pe.api_jslearn.service.DataService;

import java.util.List;

@RestController
@RequestMapping("/api/data") 
@RequiredArgsConstructor
@CrossOrigin(origins = "*") 
public class DataController {

    private final DataService dataService;

    // ===========================
    // Cargar JSON completo
    // ===========================
    @PostMapping("/insert")
    public ResponseEntity<String> insertData(@RequestBody DataDTO dataDTO) {
        dataService.insertData(dataDTO);
        return ResponseEntity.ok("Datos insertados correctamente");
    }

    // ===========================
    // Cursos
    // ===========================
    @GetMapping("/cursos")
    public List<Curso> getCursos() {
        return dataService.getAllCursos();
    }

    @GetMapping("/cursos/{id}")
    public Curso getCurso(@PathVariable Long id) {
        return dataService.getCursoById(id);
    }

    @PostMapping("/cursos")
    public Curso createCurso(@RequestBody Curso curso) {
        return dataService.createCurso(curso);
    }

    @PutMapping("/cursos/{id}")
    public Curso updateCurso(@PathVariable Long id, @RequestBody Curso curso) {
        return dataService.updateCurso(id, curso);
    }

    @DeleteMapping("/cursos/{id}")
    public ResponseEntity<String> deleteCurso(@PathVariable Long id) {
        dataService.deleteCurso(id);
        return ResponseEntity.ok("Curso eliminado");
    }

    // ===========================
    // Modulos
    // ===========================
    @GetMapping("/modulos")
    public List<Modulo> getModulos() {
        return dataService.getAllModulos();
    }

    @GetMapping("/modulos/{id}")
    public Modulo getModulo(@PathVariable Long id) {
        return dataService.getModuloById(id);
    }

    @PostMapping("/modulos")
    public Modulo createModulo(@RequestBody Modulo modulo) {
        return dataService.createModulo(modulo);
    }

    @PutMapping("/modulos/{id}")
    public Modulo updateModulo(@PathVariable Long id, @RequestBody Modulo modulo) {
        return dataService.updateModulo(id, modulo);
    }

    @DeleteMapping("/modulos/{id}")
    public ResponseEntity<String> deleteModulo(@PathVariable Long id) {
        dataService.deleteModulo(id);
        return ResponseEntity.ok("Módulo eliminado");
    }

    // ===========================
    // Lecciones
    // ===========================
    @GetMapping("/lecciones")
    public List<Leccion> getLecciones() {
        return dataService.getAllLecciones();
    }

    @GetMapping("/lecciones/{id}")
    public Leccion getLeccion(@PathVariable Long id) {
        return dataService.getLeccionById(id);
    }

    @PostMapping("/lecciones")
    public Leccion createLeccion(@RequestBody Leccion leccion) {
        return dataService.createLeccion(leccion);
    }

    @PutMapping("/lecciones/{id}")
    public Leccion updateLeccion(@PathVariable Long id, @RequestBody Leccion leccion) {
        return dataService.updateLeccion(id, leccion);
    }

    @DeleteMapping("/lecciones/{id}")
    public ResponseEntity<String> deleteLeccion(@PathVariable Long id) {
        dataService.deleteLeccion(id);
        return ResponseEntity.ok("Lección eliminada");
    }

    // ===========================
    // Preguntas
    // ===========================
    @GetMapping("/preguntas")
    public List<Pregunta> getPreguntas() {
        return dataService.getAllPreguntas();
    }

    @GetMapping("/preguntas/{id}")
    public Pregunta getPregunta(@PathVariable Long id) {
        return dataService.getPreguntaById(id);
    }

    @PostMapping("/preguntas")
    public Pregunta createPregunta(@RequestBody Pregunta pregunta) {
        return dataService.createPregunta(pregunta);
    }

    @PutMapping("/preguntas/{id}")
    public Pregunta updatePregunta(@PathVariable Long id, @RequestBody Pregunta pregunta) {
        return dataService.updatePregunta(id, pregunta);
    }

    @DeleteMapping("/preguntas/{id}")
    public ResponseEntity<String> deletePregunta(@PathVariable Long id) {
        dataService.deletePregunta(id); // solo se ejecuta
        return ResponseEntity.ok("Pregunta eliminada"); // retorno aquí
    }

    // ===========================
    // Opciones
    // ===========================
    @GetMapping("/opciones")
    public List<Opcion> getOpciones() {
        return dataService.getAllOpciones();
    }

    @GetMapping("/opciones/{id}")
    public Opcion getOpcion(@PathVariable Long id) {
        return dataService.getOpcionById(id);
    }

    @PostMapping("/opciones")
    public Opcion createOpcion(@RequestBody Opcion opcion) {
        return dataService.createOpcion(opcion);
    }

    @PutMapping("/opciones/{id}")
    public Opcion updateOpcion(@PathVariable Long id, @RequestBody Opcion opcion) {
        return dataService.updateOpcion(id, opcion);
    }

    @DeleteMapping("/opciones/{id}")
    public ResponseEntity<String> deleteOpcion(@PathVariable Long id) {
        dataService.deleteOpcion(id);
        return ResponseEntity.ok("Opción eliminada");
    }
}
