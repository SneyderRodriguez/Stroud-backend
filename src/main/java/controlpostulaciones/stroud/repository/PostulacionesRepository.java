package controlpostulaciones.stroud.repository;

import controlpostulaciones.stroud.model.PostulacionesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostulacionesRepository extends JpaRepository<PostulacionesModel, Integer> {
}
