package upn.pe.api_jslearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upn.pe.api_jslearn.model.Opcion;

import java.util.List;

public interface IOpcionRepository extends JpaRepository<Opcion, Long> {

    List<Opcion> findByPreguntaIdOrderByNumeroOrdenAsc(Long preguntaId);
}
