package br.edu.ibmec.album.model;

import br.edu.ibmec.album.domain.DadosCadastroMusica;
import br.edu.ibmec.album.domain.DadosDetalheMusica;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity(name = "Musica")
@Table
@AllArgsConstructor
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id, nome")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "compositorId")
    private Compositor compositor;

    public Musica(DadosCadastroMusica dados, Compositor compositor){
        this.nome = dados.nome();
        this.compositor = compositor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
