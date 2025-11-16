package upn.pe.api_jslearn.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "leccion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Leccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String contenido;

    // Para YouTube puedes guardar la URL completa o solo el ID
    private String videoUrl;

    @Column(columnDefinition = "TEXT")
    private String intro1;

    @Column(columnDefinition = "TEXT")
    private String intro2;

    @Column(columnDefinition = "TEXT")
    private String intro3;

    private Integer numeroOrden; // orden dentro del módulo

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modulo_id", nullable = false)
    private Modulo modulo;

    @OneToMany(mappedBy = "leccion", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    private List<Pregunta> preguntas = new ArrayList<>();
}
