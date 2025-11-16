package upn.pe.api_jslearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upn.pe.api_jslearn.model.Pregunta;

import java.util.List;

public interface IPreguntaRepository extends JpaRepository<Pregunta, Long> {

    List<Pregunta> findByLeccionIdOrderByNumeroOrdenAsc(Long leccionId);
}
