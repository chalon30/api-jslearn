package upn.pe.api_jslearn.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "respuesta_pregunta",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"usuario_id", "leccion_id", "pregunta_id"}
        )
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RespuestaPregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 👤 Usuario que respondió
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // 📚 Lección donde está la pregunta
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leccion_id", nullable = false)
    private Leccion leccion;

    // ❓ Pregunta respondida
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pregunta_id", nullable = false)
    private Pregunta pregunta;

    // ✅ Opción seleccionada por el usuario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "opcion_id", nullable = false)
    private Opcion opcionSeleccionada;

    // true = respondió correctamente
    @Column(nullable = false)
    private boolean correcta;

    // Cuándo respondió
    @Column(nullable = false)
    private LocalDateTime fechaRespuesta;
}
