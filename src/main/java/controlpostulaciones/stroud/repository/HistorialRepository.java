package controlpostulaciones.stroud.repository;

import controlpostulaciones.stroud.model.HistorialModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HistorialRepository extends JpaRepository<HistorialModel, Integer> {
    @Query(value = "SELECT historial.* FROM historial JOIN (SELECT id_postulaciones, MAX(fecha_cambio) AS ultima_fecha FROM historial GROUP BY id_postulaciones) AS ult ON historial.id_postulaciones = ult.id_postulaciones AND historial.fecha_cambio = ult.ultima_fecha", nativeQuery = true)
    List<HistorialModel> postulacionesLaboralesHistoria();
}
