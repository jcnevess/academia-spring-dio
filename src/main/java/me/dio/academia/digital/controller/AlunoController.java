package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false)
                                  String dataDeNascimento) {
        return service.getAll(dataDeNascimento);
    }

    @GetMapping("/{id}")
    public Aluno get(@PathVariable Long id) {
        return service.get(id);
    }

    @PatchMapping("/{id}")
    public Aluno update(@PathVariable Long id, @RequestBody AlunoUpdateForm form) {
        return service.update(id, form);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}/avaliacao")
    public List<AvaliacaoFisica> getAllAvaliacaoFisica(@PathVariable("id") Long idAluno) {
        return service.getAllAvaliacaoFisicaAluno(idAluno);
    }

}
