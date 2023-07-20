package br.com.api.locadora.service;

import br.com.api.locadora.filme.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public void deletarFilme(Long id) {
        filmeRepository.deleteById(id);
    }
}
