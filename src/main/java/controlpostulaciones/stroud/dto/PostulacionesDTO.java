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

    /*Creamos el metodo desde quien se encargara de fabricar el Historial*/
    public static PostulacionesDTO desde(HistorialModel historial) {
        PostulacionesDTO dto = new PostulacionesDTO();
        dto.setId(historial.getPostulacion().getId());
        dto.setFechaPostulacion(historial.getPostulacion().getFechaPostulacion());
        dto.setVacante(historial.getPostulacion().getNombreDeLaVacante());
        dto.setEmpresa(historial.getPostulacion().getEmpresaDeLaVacante());
        dto.setEstado(historial.getEstadoPostulacion().getEstadoDeLaPostulacion());
        dto.setBolsaDeEmpleo(historial.getPostulacion().getBolsaDeEmpleo());
        dto.setUrl(historial.getPostulacion().getUrlDeLaVacante());
        /*Creamos una variable la cual llame el String de estado_de_la_postulacion*/
        String estd = historial.getEstadoPostulacion().getEstadoDeLaPostulacion();
        /*Hacemos la comparación indicando que Si el estado NO es contradado y NO es rechazado
        * haga el cálculo de los díaas en espera por espuesta*/
        if (!estd.equals("Contratado") && !estd.equals("Rechazado")) {
            /*Cálculo de los días en espera: debido a que el cáculo de los días es un tipo de dato long
            * se convierte a int para coincidir con el tipo de dato de mi variable, la fecha de inicio = fechaCambio la fecha fin = LocalDate.now*/
            dto.setDiasSinRespuesta((int) ChronoUnit.DAYS.between(historial.getFechaCambio(), LocalDate.now()));
        }
        return dto;
    }
}
