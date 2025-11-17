package upn.pe.api_jslearn.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import upn.pe.api_jslearn.dto.*;
import upn.pe.api_jslearn.model.*;
import upn.pe.api_jslearn.repository.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataService {

    private final ICursoRepository cursoRepository;
    private final IModuloRepository moduloRepository;
    private final ILeccionRepository leccionRepository;
    private final IPreguntaRepository preguntaRepository;
    private final IOpcionRepository opcionRepository;

    // ===========================
    // Insertar datos desde JSON completo
    // ===========================
    @Transactional
    public void insertData(DataDTO dataDTO) {
        if (dataDTO.getCursos() != null) {
            for (CursoDTO cursoDTO : dataDTO.getCursos()) {
                Curso curso = Curso.builder()
                        .titulo(cursoDTO.getTitulo())
                        .descripcion(cursoDTO.getDescripcion())
                        .imagenUrl(cursoDTO.getImagenUrl())
                        .activo(true)
                        .build();
                cursoRepository.save(curso);
            }
        }

        if (dataDTO.getModulos() != null) {
            for (ModuloDTO moduloDTO : dataDTO.getModulos()) {
                Curso curso = cursoRepository.findById(moduloDTO.getId())
                        .orElseThrow(() -> new RuntimeException("Curso no encontrado para módulo"));
                Modulo modulo = Modulo.builder()
                        .titulo(moduloDTO.getTitulo())
                        .numeroOrden(moduloDTO.getNumeroOrden())
                        .curso(curso)
                        .build();
                moduloRepository.save(modulo);
            }
        }

        if (dataDTO.getLecciones() != null) {
            for (LeccionDTO leccionDTO : dataDTO.getLecciones()) {
                Modulo modulo = moduloRepository.findById(leccionDTO.getId())
                        .orElseThrow(() -> new RuntimeException("Módulo no encontrado para lección"));
                Leccion leccion = Leccion.builder()
                        .titulo(leccionDTO.getTitulo())
                        .contenido(leccionDTO.getContenido())
                        .videoUrl(leccionDTO.getVideoUrl())
                        .intro1(leccionDTO.getIntro1())
                        .intro2(leccionDTO.getIntro2())
                        .intro3(leccionDTO.getIntro3())
                        .numeroOrden(leccionDTO.getNumeroOrden())
                        .modulo(modulo)
                        .build();
                leccionRepository.save(leccion);
            }
        }

        if (dataDTO.getPreguntas() != null) {
            for (PreguntaDTO preguntaDTO : dataDTO.getPreguntas()) {
                Leccion leccion = leccionRepository.findById(preguntaDTO.getId())
                        .orElseThrow(() -> new RuntimeException("Lección no encontrada para pregunta"));
                Pregunta pregunta = Pregunta.builder()
                        .enunciado(preguntaDTO.getEnunciado())
                        .explicacion(preguntaDTO.getExplicacion())
                        .numeroOrden(preguntaDTO.getNumeroOrden())
                        .leccion(leccion)
                        .build();
                preguntaRepository.save(pregunta);
            }
        }

        if (dataDTO.getOpciones() != null) {
            for (OpcionDTO opcionDTO : dataDTO.getOpciones()) {
                Pregunta pregunta = preguntaRepository.findById(opcionDTO.getId())
                        .orElseThrow(() -> new RuntimeException("Pregunta no encontrada para opción"));
                Opcion opcion = Opcion.builder()
                        .texto(opcionDTO.getTexto())
                        .correcta(opcionDTO.isCorrecta())
                        .numeroOrden(opcionDTO.getNumeroOrden())
                        .pregunta(pregunta)
                        .build();
                opcionRepository.save(opcion);
            }
        }
    }

    // ===========================
    // CRUD Cursos
    // ===========================
    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    public Curso getCursoById(Long id) {
        return cursoRepository.findById(id).orElseThrow(() -> new RuntimeException("Curso no encontrado"));
    }

    public Curso createCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso updateCurso(Long id, Curso cursoDetails) {
        Curso curso = getCursoById(id);
        curso.setTitulo(cursoDetails.getTitulo());
        curso.setDescripcion(cursoDetails.getDescripcion());
        curso.setImagenUrl(cursoDetails.getImagenUrl());
        curso.setActivo(cursoDetails.isActivo());
        return cursoRepository.save(curso);
    }

    public void deleteCurso(Long id) {
        cursoRepository.deleteById(id);
    }

    // ===========================
    // CRUD Modulos
    // ===========================
    public List<Modulo> getAllModulos() {
        return moduloRepository.findAll();
    }

    public Modulo getModuloById(Long id) {
        return moduloRepository.findById(id).orElseThrow(() -> new RuntimeException("Módulo no encontrado"));
    }

    public Modulo createModulo(Modulo modulo) {
        return moduloRepository.save(modulo);
    }

    public Modulo updateModulo(Long id, Modulo moduloDetails) {
        Modulo modulo = getModuloById(id);
        modulo.setTitulo(moduloDetails.getTitulo());
        modulo.setNumeroOrden(moduloDetails.getNumeroOrden());
        return moduloRepository.save(modulo);
    }

    public void deleteModulo(Long id) {
        moduloRepository.deleteById(id);
    }

    // ===========================
    // CRUD Lecciones
    // ===========================
    public List<Leccion> getAllLecciones() {
        return leccionRepository.findAll();
    }

    public Leccion getLeccionById(Long id) {
        return leccionRepository.findById(id).orElseThrow(() -> new RuntimeException("Lección no encontrada"));
    }

    public Leccion createLeccion(Leccion leccion) {
        return leccionRepository.save(leccion);
    }

    public Leccion updateLeccion(Long id, Leccion leccionDetails) {
        Leccion leccion = getLeccionById(id);
        leccion.setTitulo(leccionDetails.getTitulo());
        leccion.setContenido(leccionDetails.getContenido());
        leccion.setVideoUrl(leccionDetails.getVideoUrl());
        leccion.setIntro1(leccionDetails.getIntro1());
        leccion.setIntro2(leccionDetails.getIntro2());
        leccion.setIntro3(leccionDetails.getIntro3());
        leccion.setNumeroOrden(leccionDetails.getNumeroOrden());
        return leccionRepository.save(leccion);
    }

    public void deleteLeccion(Long id) {
        leccionRepository.deleteById(id);
    }

    // ===========================
    // CRUD Preguntas
    // ===========================
    public List<Pregunta> getAllPreguntas() {
        return preguntaRepository.findAll();
    }

    public Pregunta getPreguntaById(Long id) {
        return preguntaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pregunta no encontrada"));
    }

    public Pregunta createPregunta(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    public Pregunta updatePregunta(Long id, Pregunta preguntaDetails) {
        Pregunta pregunta = getPreguntaById(id);
        pregunta.setEnunciado(preguntaDetails.getEnunciado());
        pregunta.setExplicacion(preguntaDetails.getExplicacion());
        pregunta.setNumeroOrden(preguntaDetails.getNumeroOrden());
        return preguntaRepository.save(pregunta);
    }

    public void deletePregunta(Long id) {
        preguntaRepository.deleteById(id);
    }

    // ===========================
    // CRUD Opciones
    // ===========================
    public List<Opcion> getAllOpciones() {
        return opcionRepository.findAll();
    }

    public Opcion getOpcionById(Long id) {
        return opcionRepository.findById(id).orElseThrow(() -> new RuntimeException("Opción no encontrada"));
    }

    public Opcion createOpcion(Opcion opcion) {
        return opcionRepository.save(opcion);
    }

    public Opcion updateOpcion(Long id, Opcion opcionDetails) {
        Opcion opcion = getOpcionById(id);
        opcion.setTexto(opcionDetails.getTexto());
        opcion.setCorrecta(opcionDetails.isCorrecta());
        opcion.setNumeroOrden(opcionDetails.getNumeroOrden());
        return opcionRepository.save(opcion);
    }

    public void deleteOpcion(Long id) {
        opcionRepository.deleteById(id);
    }
}
