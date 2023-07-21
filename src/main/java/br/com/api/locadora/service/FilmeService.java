package br.com.api.locadora.service;

import br.com.api.locadora.filme.Filme;
import br.com.api.locadora.filme.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {
    private FilmeRepository filmeRepository;

    public  Filme cadastrarFilme(Filme filme){
        return filmeRepository.save(filme);
    }

    public void deletarFilme(Long id) {
        filmeRepository.deleteById(id);
    }
}
