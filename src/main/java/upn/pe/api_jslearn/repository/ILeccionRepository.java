package upn.pe.api_jslearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upn.pe.api_jslearn.model.Leccion;

import java.util.List;

public interface ILeccionRepository extends JpaRepository<Leccion, Long> {

    // Obtener lecciones de un módulo ordenadas
    List<Leccion> findByModuloIdOrderByNumeroOrdenAsc(Long moduloId);
}
