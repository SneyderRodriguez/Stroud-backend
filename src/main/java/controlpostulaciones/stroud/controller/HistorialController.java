package controlpostulaciones.stroud.controller;

import controlpostulaciones.stroud.dto.PostulacionesDTO;
import controlpostulaciones.stroud.service.HistorialService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/postulaciones")
public class HistorialController {
    private final HistorialService historialService;

    public HistorialController(HistorialService historialService) {
        this.historialService = historialService;
    }
    @GetMapping("/{id}")
    public PostulacionesDTO buscarPorId(@PathVariable Integer id) {
        return historialService.findById(id);
    }
    @GetMapping
    public List<PostulacionesDTO> buscarTodos() {
        return historialService.postulacionesLaboralesHistoria();
    }
}
