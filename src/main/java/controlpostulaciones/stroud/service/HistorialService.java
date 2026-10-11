package controlpostulaciones.stroud.service;

import controlpostulaciones.stroud.dto.PostulacionesDTO;
import controlpostulaciones.stroud.model.HistorialModel;
import controlpostulaciones.stroud.repository.HistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HistorialService {
    private final HistorialRepository historialRepository;

    @Autowired
    public HistorialService(HistorialRepository historialRepository) {
        this.historialRepository = historialRepository;
    }

    @Transactional(readOnly = true)
    public List<PostulacionesDTO> postulacionesLaboralesHistoria() {
        return historialRepository.postulacionesLaboralesHistoria().stream().map(PostulacionesDTO::desde).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public PostulacionesDTO findById(Integer id) {
        Optional<HistorialModel> postulaciones = historialRepository.findFirstByPostulacionIdOrderByFechaCambioDescIdDesc(id);
        HistorialModel historial = postulaciones.orElseThrow(()->new RuntimeException("Postulacion no encontrada"));
        return PostulacionesDTO.desde(historial);
    }
}
