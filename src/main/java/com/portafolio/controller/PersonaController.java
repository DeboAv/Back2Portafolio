package com.portafolio.controller;

import com.portafolio.Dto.DtoPersona;
import com.portafolio.entity.Persona;
import com.portafolio.interfaces.IPersonaService;
import com.portafolio.security.controller.Mensaje;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://frontendportafoliodaa2.web.app")
@RequestMapping("/persona")
public class PersonaController {

    IPersonaService service;

    public PersonaController(IPersonaService personaService) {
        this.service = personaService;
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = service.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id")int id){
        if(!service.exist(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = service.findPersona(id);
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPersona dtoPersona){
        if(!service.exist(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(service.existByNombre(dtoPersona.getNombre()) && service.getByNombre(dtoPersona.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoPersona.getNombre())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = service.findPersona(id);

        persona.setNombre(dtoPersona.getNombre());
        persona.setDescripcion(dtoPersona.getDescripcion());
        persona.setApellido(dtoPersona.getApellido());
        persona.setImg(dtoPersona.getImg());

        service.savePersona(persona);

        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
}
