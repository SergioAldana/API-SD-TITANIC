package co.edu.utadeo.api_sd_titanic.controller;

import co.edu.utadeo.api_sd_titanic.helper.HelperCSV;
import co.edu.utadeo.api_sd_titanic.message.ResponseMessage;
import co.edu.utadeo.api_sd_titanic.modelEntity.Pasajero;
import co.edu.utadeo.api_sd_titanic.service.PasajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:8080")
public class PasajeroRestController {
    @Autowired
    private PasajeroService pasajeroService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message;

        if (HelperCSV.hasCSVFormat(file)) {
            try {
                pasajeroService.save(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));

    }

    @GetMapping("/pasajero")
    public List<Pasajero> findAll() {
        return pasajeroService.findAll();
    }

    /**
     * Servira sin la implementacion de este GetMapping?
     *
        @GetMapping("/pasajero")
        public ResponseEntity<List<Pasajero>> findAll() {
            try {
                List<Pasajero> pasajeros = pasajeroService.findAll();

                if (pasajeros.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }

                return new ResponseEntity<>(pasajeros, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    */

    @GetMapping("/pasajero/{id}")
    public Pasajero findById(@PathVariable Long id) {
        return pasajeroService.findById(id);
    }
}