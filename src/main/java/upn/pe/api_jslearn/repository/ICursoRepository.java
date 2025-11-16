package upn.pe.api_jslearn.repository;

//import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import upn.pe.api_jslearn.model.Curso;

import java.util.List;
//import java.util.Optional;

public interface ICursoRepository extends JpaRepository<Curso, Long> {

    // Ejemplo: obtener solo cursos activos
    List<Curso> findByActivoTrue();

    //@EntityGraph(attributePaths = {"modulos", "modulos.lecciones"})
    //Optional<Curso> findFullById(Long id);
}
