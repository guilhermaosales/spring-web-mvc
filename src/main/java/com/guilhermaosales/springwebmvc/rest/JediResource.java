package com.guilhermaosales.springwebmvc.rest;

import com.guilhermaosales.springwebmvc.model.Jedi;
import com.guilhermaosales.springwebmvc.repository.JediRepository;
import com.guilhermaosales.springwebmvc.service.JediService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class JediResource {

    @Autowired
    private JediService service;

    @GetMapping("/jedi")
    public List<Jedi> getAllJedi() {

        return service.findAll();

    }

    @GetMapping("/jedi/{id}")
    public ResponseEntity<Jedi> getJedi(@PathVariable("id") Long id) {
        final Jedi jedi = service.findById(id);

        return ResponseEntity.ok(jedi);
    }

    @PostMapping("/jedi")
    @ResponseStatus(HttpStatus.CREATED)
    public Jedi createJedi(@Valid @RequestBody Jedi jedi){

        return service.save(jedi);
    }

    @PutMapping("/jedi/{id}")
    public ResponseEntity<Jedi> updateJedi(@PathVariable("id") Long id, @Valid @RequestBody Jedi dto) {

        final Jedi jedi = service.update(id, dto);

        return ResponseEntity.ok(jedi);

    }

    @DeleteMapping("/jedi/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
