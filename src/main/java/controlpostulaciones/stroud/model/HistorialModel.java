package controlpostulaciones.stroud.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name = "historial")
@Getter
@Setter
@NoArgsConstructor
public class HistorialModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_estados", nullable = false, foreignKey = @ForeignKey(name = "historial_estados_postulaciones_id_fkey"))
    private EstadosPostulacionesModel estadoPostulacion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_postulaciones", nullable = false, foreignKey = @ForeignKey(name = "historial_postulaciones_id_fkey"))
    private PostulacionesModel postulacion;

    @Column(nullable = false, name = "fecha_cambio")
    private LocalDate fechaCambio;
}
