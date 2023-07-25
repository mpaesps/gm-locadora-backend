package br.com.api.locadora.service;

import br.com.api.locadora.filme.Filme;
import br.com.api.locadora.filme.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        Filme updtFilme = buscarFilmeId(filme.getId());
        updtFilme.setTitulo(filme.getTitulo());
        updtFilme.setDuracao(filme.getDuracao());
        updtFilme.setAno(filme.getAno());
        updtFilme.setGenero(filme.getGenero());
        return filmeRepository.save(updtFilme);
    }


}
