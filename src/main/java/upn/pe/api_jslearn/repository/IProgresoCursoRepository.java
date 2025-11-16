package upn.pe.api_jslearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upn.pe.api_jslearn.model.ProgresoCurso;

import java.util.List;
import java.util.Optional;

public interface IProgresoCursoRepository extends JpaRepository<ProgresoCurso, Long> {

    Optional<ProgresoCurso> findByUsuarioIdAndCursoId(Long usuarioId, Long cursoId);

    List<ProgresoCurso> findByUsuarioId(Long usuarioId);
}
