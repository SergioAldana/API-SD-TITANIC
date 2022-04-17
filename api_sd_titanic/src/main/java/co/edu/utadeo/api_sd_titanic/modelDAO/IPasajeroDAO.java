package co.edu.utadeo.api_sd_titanic.modelDAO;

import co.edu.utadeo.api_sd_titanic.modelEntity.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPasajeroDAO extends JpaRepository<Pasajero, Long> {

}
