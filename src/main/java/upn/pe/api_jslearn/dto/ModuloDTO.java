package upn.pe.api_jslearn.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModuloDTO {

    private Long id;
    private String titulo;
    private Integer numeroOrden;

    private List<LeccionDTO> lecciones;
}
