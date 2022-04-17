package co.edu.utadeo.api_sd_titanic.controller;

import co.edu.utadeo.api_sd_titanic.modelEntity.Pasajero;
import co.edu.utadeo.api_sd_titanic.service.PasajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PasajeroRestController {
    @Autowired
    private PasajeroService pasajeroService;

    @GetMapping("/pasajero")
    public List<Pasajero> findAll() {
        return pasajeroService.findAll();
    }

    @GetMapping("/pasajero/{id}")
    public Pasajero findById(@PathVariable Long id) {
        return pasajeroService.findById(id);
    }
}