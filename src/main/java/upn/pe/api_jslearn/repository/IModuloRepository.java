package upn.pe.api_jslearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upn.pe.api_jslearn.model.Modulo;

import java.util.List;

public interface IModuloRepository extends JpaRepository<Modulo, Long> {

    // Obtener módulos de un curso ordenados
    List<Modulo> findByCursoIdOrderByNumeroOrdenAsc(Long cursoId);
}
