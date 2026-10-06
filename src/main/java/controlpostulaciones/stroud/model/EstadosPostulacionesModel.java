package controlpostulaciones.stroud.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="estados_postulaciones")
@Getter @Setter
@NoArgsConstructor
public class EstadosPostulacionesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true,name = "estado_de_la_postulacion", length = 25)
    private String estadoDeLaPostulacion;
}