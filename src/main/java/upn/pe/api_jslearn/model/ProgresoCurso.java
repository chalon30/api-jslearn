package upn.pe.api_jslearn.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "progreso_curso",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"usuario_id", "curso_id"}
        )
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgresoCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @Column(nullable = false)
    private int porcentaje; // 0–100

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ultima_leccion_id")
    private Leccion ultimaLeccion; // opcional

    private LocalDateTime fechaUltimaActividad;

    // ✅ CORRECTO PARA BUILDER + VALOR POR DEFECTO
    @Builder.Default
    @Column(nullable = false)
    private boolean cursoCompletado = false;
}
