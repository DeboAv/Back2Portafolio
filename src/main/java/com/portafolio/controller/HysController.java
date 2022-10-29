package com.portafolio.controller;

import com.portafolio.Dto.DtoHys;
import com.portafolio.entity.Hys;
import com.portafolio.interfaces.IHysService;
import com.portafolio.security.controller.Mensaje;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://frontendportafoliodaa.web.app")
@RequestMapping("/skill")
public class HysController {

    @Autowired
    IHysService hysService;

    @GetMapping("/lista")
    public ResponseEntity<List<Hys>> list() {
        List<Hys> list = hysService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Hys> getById(@PathVariable("id") int id) {
        if (!hysService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Hys hYs = hysService.getOne(id).get();
        return new ResponseEntity(hYs, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!hysService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        hysService.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoHys dtohys) {
        if (StringUtils.isBlank(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (hysService.existsByNombre(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        Hys hYs = new Hys(dtohys.getNombre(), dtohys.getPorcentaje());
        hysService.save(hYs);

        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoHys dtohys) {

        if (!hysService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        if (hysService.existsByNombre(dtohys.getNombre()) && hysService.getByNombre(dtohys.getNombre()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Hys hYs = hysService.getOne(id).get();
        hYs.setNombre(dtohys.getNombre());
        hYs.setPorcentaje(dtohys.getPorcentaje());

        hysService.save(hYs);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);

    }
}