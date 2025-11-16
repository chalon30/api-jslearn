package upn.pe.api_jslearn.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "opcion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Opcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Texto de la opción
    @Column(columnDefinition = "TEXT", nullable = false)
    private String texto;

    // Marca si esta opción es la correcta
    private boolean correcta;

    private Integer numeroOrden; // para mostrar A, B, C, D en orden

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pregunta_id", nullable = false)
    private Pregunta pregunta;
}
