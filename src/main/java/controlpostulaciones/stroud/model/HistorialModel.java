package controlpostulaciones.stroud.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
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
    @JoinColumn(name = "id", nullable = false, foreignKey = @ForeignKey(name = "historial_estados_postulaciones_id_fkey"))
    private EstadosPostulacionesModel estadosPostulaciones;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false, foreignKey = @ForeignKey(name = "historial_postulaciones_id_fkey"))
    private PostulacionesModel postulaciones;
    @Column(nullable = false, name = "fecha_cambio")
    private LocalDateTime fechaCambio;
}
