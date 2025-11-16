package upn.pe.api_jslearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upn.pe.api_jslearn.model.InscripcionCurso;

import java.util.List;
import java.util.Optional;

public interface IInscripcionCursoRepository extends JpaRepository<InscripcionCurso, Long> {

    Optional<InscripcionCurso> findByUsuarioIdAndCursoId(Long usuarioId, Long cursoId);

    List<InscripcionCurso> findByUsuarioId(Long usuarioId);

    List<InscripcionCurso> findByCursoId(Long cursoId);
}
