package co.edu.utadeo.api_sd_titanic.service;

import co.edu.utadeo.api_sd_titanic.modelDAO.IPasajeroDAO;
import co.edu.utadeo.api_sd_titanic.modelEntity.Pasajero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasajeroService implements IPasajeroService {
    @Autowired
    private IPasajeroDAO pasajeroDAO;

    @Override
    public List<Pasajero> findAll() {
        return pasajeroDAO.findAll();
    }

    @Override
    public Pasajero findById(Long id) {
        return pasajeroDAO.findById(id).orElse(null);
    }
}