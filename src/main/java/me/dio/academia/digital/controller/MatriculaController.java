package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.service.impl.MatriculaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {

    @Autowired
    private MatriculaServiceImpl service;

    @PostMapping
    public ResponseEntity<Matricula> create(@Valid @RequestBody MatriculaForm form){
        return new ResponseEntity<>(service.create(form), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Matricula> getAll(@RequestParam(name="bairro", required = false) String bairro) {
        return service.getAll(bairro);
    }

    @GetMapping("/{id}")
    public Matricula get(@PathVariable Long id) {
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
