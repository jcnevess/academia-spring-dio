package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;

    @PostMapping
    public ResponseEntity<Aluno> create(@Valid @RequestBody AlunoForm form){
        return new ResponseEntity<>(service.create(form), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Aluno>> getAll(
            @RequestParam(value = "dataDeNascimento", required = false) String dataDeNascimento) {
        return ResponseEntity.ok(service.getAll(dataDeNascimento));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody AlunoUpdateForm form) {
        return ResponseEntity.ok(service.update(id, form));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/avaliacao")
    public ResponseEntity<Iterable<AvaliacaoFisica>> getAllAvaliacaoFisica(
            @PathVariable("id") Long idAluno) {
        return ResponseEntity.ok(service.getAllAvaliacaoFisicaAluno(idAluno));
    }

}
