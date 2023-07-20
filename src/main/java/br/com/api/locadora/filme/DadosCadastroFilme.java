package br.com.api.locadora.filme;

import org.antlr.v4.runtime.misc.NotNull;

public record DadosCadastroFilme(
        @NotNull
        String titulo,
        @NotNull
        String duracao,
        @NotNull
        String ano,
        @NotNull
        Genero genero) {

//quantidade no estoque
//disponivel
}
