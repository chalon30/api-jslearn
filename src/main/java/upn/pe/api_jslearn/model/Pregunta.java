package upn.pe.api_jslearn.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pregunta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Enunciado de la pregunta
    @Column(columnDefinition = "TEXT", nullable = false)
    private String enunciado;

    // Explicación opcional que puedes mostrar después de responder
    @Column(columnDefinition = "TEXT")
    private String explicacion;

    private Integer numeroOrden; // orden dentro de la lección

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leccion_id", nullable = false)
    private Leccion leccion;

    @OneToMany(
            mappedBy = "pregunta",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @Builder.Default
    private List<Opcion> opciones = new ArrayList<>();
}
