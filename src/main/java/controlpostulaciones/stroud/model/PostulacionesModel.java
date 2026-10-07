package controlpostulaciones.stroud.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name = "postulaciones")
@Getter
@Setter
@NoArgsConstructor
public class PostulacionesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, name = "fecha_postulacion")
    private LocalDate fechaPostulacion;
    @Column(nullable = false, name = "nombre_de_la_vacante", length = 150)
    private String nombreDeLaVacante;
    @Column(nullable = false, name = "empresa_de_la_vacante", length = 75)
    private String empresaDeLaVacante;
    @Column(name = "bolsa_de_empleo", length = 100)
    private String bolsaDeEmpleo;
    @Column(name = "url_de_la_vacante")
    private String urlDeLaVacante;
}
