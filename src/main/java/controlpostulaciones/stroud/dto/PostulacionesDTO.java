package controlpostulaciones.stroud.dto;

import controlpostulaciones.stroud.model.HistorialModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
    public static PostulacionesDTO desde(HistorialModel historial) {
        PostulacionesDTO dto = new PostulacionesDTO();
        dto.setId(historial.getPostulacion().getId());
        dto.setFechaPostulacion(historial.getPostulacion().getFechaPostulacion());
        dto.setVacante(historial.getPostulacion().getNombreDeLaVacante());
        dto.setEmpresa(historial.getPostulacion().getEmpresaDeLaVacante());
        dto.setEstado(historial.getEstadoPostulacion().getEstadoDeLaPostulacion());
        dto.setBolsaDeEmpleo(historial.getPostulacion().getBolsaDeEmpleo());
        dto.setUrl(historial.getPostulacion().getUrlDeLaVacante());
        String estd = historial.getEstadoPostulacion().getEstadoDeLaPostulacion();
        if (!estd.equals("Contratado") && !estd.equals("Rechazado")) {
            dto.setDiasSinRespuesta((int) ChronoUnit.DAYS.between(historial.getFechaCambio(), LocalDate.now()));
        }
        return dto;
    }
}
