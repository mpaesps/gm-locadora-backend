package br.com.api.locadora.controller;


import br.com.api.locadora.filme.DadosCadastroFilme;
import br.com.api.locadora.filme.Filme;
import br.com.api.locadora.filme.FilmeRepository;
import br.com.api.locadora.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
@Transactional
@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    FilmeRepository repository;
    FilmeService filmeService;

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrarFilme(@RequestBody DadosCadastroFilme dados){
        var filme = new Filme(dados);
        repository.save(filme);
        return ResponseEntity.ok("Filme cadastrado");
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deletarFilme(@PathVariable Long id){
        filmeService.deletarFilme(id);
        return ResponseEntity.ok("Filme deletado");
    }
}

