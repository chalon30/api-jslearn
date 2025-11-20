package upn.pe.api_jslearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import upn.pe.api_jslearn.model.RespuestaPregunta;

public interface IRespuestaPreguntaRepository extends JpaRepository<RespuestaPregunta, Long> {

    // Opcional: para obtener todas las respuestas de un usuario en una lección
    List<RespuestaPregunta> findByUsuarioIdAndLeccionId(Long usuarioId, Long leccionId);

    // Opcional: para obtener la respuesta a una pregunta específica
    RespuestaPregunta findByUsuarioIdAndPreguntaId(Long usuarioId, Long preguntaId);

    // Opcional: eliminar todas las respuestas de una lección (si el usuario vuelve a hacer el quiz)
    void deleteByUsuarioIdAndLeccionId(Long usuarioId, Long leccionId);
}
