package upn.pe.api_jslearn.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "inscripcion_curso",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"usuario_id", "curso_id"}
        )
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InscripcionCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @Column(nullable = false, length = 20)
    private String estado; // ACTIVO, RETIRADO, COMPLETADO

    @Column(nullable = false)
    private LocalDateTime fechaInscripcion;

    private LocalDateTime fechaCompletado;
}
