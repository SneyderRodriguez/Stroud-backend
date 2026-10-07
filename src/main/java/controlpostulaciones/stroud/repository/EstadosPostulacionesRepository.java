package controlpostulaciones.stroud.repository;

import controlpostulaciones.stroud.model.EstadosPostulacionesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadosPostulacionesRepository extends JpaRepository<EstadosPostulacionesModel, Integer> {
}
