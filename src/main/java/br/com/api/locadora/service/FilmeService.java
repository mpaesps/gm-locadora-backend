package br.com.api.locadora.service;

import br.com.api.locadora.filme.Filme;
import br.com.api.locadora.filme.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public  Filme cadastrarFilme(Filme filme){
        return filmeRepository.save(filme);
    }

    public void deletarFilme(Long id) {
        filmeRepository.deleteById(id);
    }

    public List<Filme> listarFilme() {
        return filmeRepository.findAll();
    }

    public Filme buscarFilmeId(Long id) {
        return  filmeRepository.findById(id).orElse(null);
    }

    public  Filme atualizarFilme(Long id, Filme filme) {
        if (filme != null) {
            ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();
            Example<Filme> example = Example.of(filme, matcher);
        }
        Filme updtFilme = filmeRepository.save(filme);

        return updtFilme;
    }

}
