package br.com.api.locadora.filme;

import jakarta.persistence.*;
import lombok.*;

@Table(name="filmes")
@Entity(name ="Filme")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Filme {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String duracao;
    private String ano;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    public Filme(DadosCadastroFilme dados) {
        this.titulo = dados.titulo();
        this.duracao = dados.duracao();
        this.ano = dados.ano();
        this.genero = dados.genero();
    }



}
