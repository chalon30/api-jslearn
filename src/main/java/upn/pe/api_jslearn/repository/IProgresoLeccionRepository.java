package upn.pe.api_jslearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upn.pe.api_jslearn.model.ProgresoLeccion;

import java.util.List;
import java.util.Optional;

public interface IProgresoLeccionRepository extends JpaRepository<ProgresoLeccion, Long> {

    Optional<ProgresoLeccion> findByUsuarioIdAndLeccionId(Long usuarioId, Long leccionId);

    List<ProgresoLeccion> findByUsuarioIdAndLeccion_Modulo_Curso_Id(Long usuarioId, Long cursoId);
}
