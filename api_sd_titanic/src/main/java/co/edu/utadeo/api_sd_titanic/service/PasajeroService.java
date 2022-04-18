package co.edu.utadeo.api_sd_titanic.service;

import co.edu.utadeo.api_sd_titanic.helper.HelperCSV;
import co.edu.utadeo.api_sd_titanic.modelDAO.IPasajeroDAO;
import co.edu.utadeo.api_sd_titanic.modelEntity.Pasajero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class PasajeroService implements IPasajeroService {
    @Autowired
    private IPasajeroDAO pasajeroDAO;

    @Override
    public void save(MultipartFile file) {
        try {
            List<Pasajero> pasajeros = HelperCSV.csvToPassengers(file.getInputStream());
            pasajeroDAO.saveAll(pasajeros);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    @Override
    public List<Pasajero> findAll() {
        return pasajeroDAO.findAll();
    }

    @Override
    public Pasajero findById(Long id) {
        return pasajeroDAO.findById(id).orElse(null);
    }

    /**
     * Creo que aqui sera en donde deba sobreescribir los metodos
     * y agregarle funcionalidad para implementarlos mas adelante
     */
}