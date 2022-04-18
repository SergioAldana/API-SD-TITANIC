package co.edu.utadeo.api_sd_titanic.service;

import co.edu.utadeo.api_sd_titanic.modelEntity.Pasajero;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IPasajeroService {

    void save(MultipartFile file);

    List<Pasajero> findAll();

    Pasajero findById(Long id);
}
