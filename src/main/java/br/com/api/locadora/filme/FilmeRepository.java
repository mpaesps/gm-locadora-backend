package br.com.api.locadora.filme;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
