package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.service.impl.MatriculaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public ResponseEntity<Iterable<Matricula>> getAll(
            @RequestParam(name="bairro", required = false) String bairro) {
        return ResponseEntity.ok(service.getAll(bairro));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
