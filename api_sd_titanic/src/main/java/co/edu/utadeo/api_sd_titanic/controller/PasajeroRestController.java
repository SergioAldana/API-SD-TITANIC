package co.edu.utadeo.api_sd_titanic.controller;

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

    @GetMapping("/usuario")
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    @GetMapping("/usuario/{id}")
    public Usuario findById(@PathVariable Long id) {
        return usuarioService.findById(id);
    }

    @PostMapping("/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @DeleteMapping("/usuario/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        usuarioService.remove(id);
    }

    @PutMapping("/usuario/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario actualizado = usuarioService.findById(id);
        actualizado.setNombre(usuario.getNombre());
        actualizado.setApellido(usuario.getApellido());
        actualizado.setFechaNac(usuario.getFechaNac());
        return usuarioService.save(usuario);
    }
}