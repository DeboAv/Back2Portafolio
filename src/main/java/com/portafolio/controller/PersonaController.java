package com.portafolio.controller;

import com.portafolio.entity.Persona;
import com.portafolio.interfaces.IPersonaService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://frontendportafoliodaa.web.app")
public class PersonaController {

    IPersonaService personaService;

    public PersonaController(IPersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping("/index")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/persona/traer/perfil")
    public Persona findPersona(){
        return personaService.findPersona(1L);
    }

    @GetMapping("/persona/traer")
    public List<Persona> getPersona(){
        return personaService.getPersona();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/persona/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("img") String img){
        Persona persona = personaService.findPersona(id);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(img);
        personaService.savePersona(persona);
        return persona;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/persona/crear")
    public String createPersona(@RequestBody Persona persona){
        personaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/persona/eliminar/{id}")
    public String deletePersona(@PathVariable Long id){
        personaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
}
