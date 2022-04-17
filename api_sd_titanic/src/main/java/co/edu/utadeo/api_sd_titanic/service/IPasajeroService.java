package co.edu.utadeo.api_sd_titanic.service;

import co.edu.utadeo.api_sd_titanic.modelEntity.Pasajero;

import java.util.List;

public interface IPasajeroService {

    List<Pasajero> findAll();

    Usuario findById(Long id);

    Usuario save(Usuario usuario);

    void remove(Long id);

}
