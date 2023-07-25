package br.com.api.locadora.controller;


import br.com.api.locadora.filme.DadosCadastroFilme;
import br.com.api.locadora.filme.Filme;
import br.com.api.locadora.filme.FilmeRepository;
import br.com.api.locadora.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    FilmeService filmeService;

    @PostMapping
    @Transactional
    public ResponseEntity<Filme> cadastrarFilme(@RequestBody Filme filme) {
        filmeService.cadastrarFilme(filme);
        return ResponseEntity.ok(filme);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deletarFilme(@PathVariable Long id) {
        filmeService.deletarFilme(id);
        return ResponseEntity.ok("Filme deletado");
    }

    @GetMapping
    public ResponseEntity<List<Filme>> listarFilme() {
        List<Filme> filme = filmeService.listarFilme();
        return ResponseEntity.ok(filme);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> buscarFilmeId(@PathVariable Long id) {
        Filme filme = filmeService.buscarFilmeId(id);
        if (filme != null) {
            return ResponseEntity.ok(filme);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Filme> atualizarFilme(@PathVariable Long id, @RequestBody Filme filme) {
        Filme updtFilme = filmeService.atualizarFilme(id, filme);
        return ResponseEntity.ok().body(updtFilme);

    }
}


