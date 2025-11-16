package upn.pe.api_jslearn.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CursoDTO {

    private Long id;
    private String titulo;
    private String descripcion;
    private String imagenUrl;

    private List<ModuloDTO> modulos;
}
