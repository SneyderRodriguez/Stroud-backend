package controlpostulaciones.stroud.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
public class PostulacionesDTO {
    private Integer id;
    private LocalDate fechaPostulacion;
    private String vacante;
    private String empresa;
    private String estado;
    private String bolsaDeEmpleo;
    private String url;
    private Integer diasSinRespuesta;
}
