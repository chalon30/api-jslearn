package upn.pe.api_jslearn.mapper;

import upn.pe.api_jslearn.dto.CursoDTO;
import upn.pe.api_jslearn.dto.ModuloDTO;
import upn.pe.api_jslearn.dto.OpcionDTO;
import upn.pe.api_jslearn.dto.PreguntaDTO;
import upn.pe.api_jslearn.dto.LeccionDTO;
import upn.pe.api_jslearn.model.Curso;
import upn.pe.api_jslearn.model.Modulo;
import upn.pe.api_jslearn.model.Opcion;
import upn.pe.api_jslearn.model.Pregunta;
import upn.pe.api_jslearn.model.Leccion;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CursoMapper {

        public static CursoDTO toCursoDTO(Curso curso) {
                List<ModuloDTO> modulos = curso.getModulos()
                                .stream()
                                .sorted(Comparator.comparing(m -> m.getNumeroOrden() == null ? 0 : m.getNumeroOrden()))
                                .map(CursoMapper::toModuloDTO)
                                .collect(Collectors.toList());

                return CursoDTO.builder()
                                .id(curso.getId())
                                .titulo(curso.getTitulo())
                                .descripcion(curso.getDescripcion())
                                .imagenUrl(curso.getImagenUrl())
                                .modulos(modulos)
                                .build();
        }

        private static ModuloDTO toModuloDTO(Modulo modulo) {
                List<LeccionDTO> lecciones = modulo.getLecciones()
                                .stream()
                                .sorted(Comparator.comparing(l -> l.getNumeroOrden() == null ? 0 : l.getNumeroOrden()))
                                .map(CursoMapper::toLeccionDTO)
                                .collect(Collectors.toList());

                return ModuloDTO.builder()
                                .id(modulo.getId())
                                .titulo(modulo.getTitulo())
                                .numeroOrden(modulo.getNumeroOrden())
                                .lecciones(lecciones)
                                .build();
        }

        private static LeccionDTO toLeccionDTO(Leccion leccion) {

                var preguntasDTO = leccion.getPreguntas()
                                .stream()
                                .sorted(Comparator.comparing(p -> p.getNumeroOrden() == null ? 0 : p.getNumeroOrden()))
                                .map(CursoMapper::toPreguntaDTO)
                                .toList();

                return LeccionDTO.builder()
                                .id(leccion.getId())
                                .titulo(leccion.getTitulo())
                                .contenido(leccion.getContenido())
                                .videoUrl(leccion.getVideoUrl())
                                .intro1(leccion.getIntro1())
                                .intro2(leccion.getIntro2())
                                .intro3(leccion.getIntro3())
                                .numeroOrden(leccion.getNumeroOrden())
                                .preguntas(preguntasDTO)
                                .build();
        }

        private static OpcionDTO toOpcionDTO(Opcion opcion) {
                return OpcionDTO.builder()
                                .id(opcion.getId())
                                .texto(opcion.getTexto())
                                .correcta(opcion.isCorrecta())
                                .numeroOrden(opcion.getNumeroOrden())
                                .build();
        }

        private static PreguntaDTO toPreguntaDTO(Pregunta pregunta) {

                var opcionesDTO = pregunta.getOpciones()
                                .stream()
                                .sorted(Comparator.comparing(o -> o.getNumeroOrden() == null ? 0 : o.getNumeroOrden()))
                                .map(CursoMapper::toOpcionDTO)
                                .toList();

                return PreguntaDTO.builder()
                                .id(pregunta.getId())
                                .enunciado(pregunta.getEnunciado())
                                .explicacion(pregunta.getExplicacion())
                                .numeroOrden(pregunta.getNumeroOrden())
                                .opciones(opcionesDTO)
                                .build();
        }

}
