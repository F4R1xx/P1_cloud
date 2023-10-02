package br.edu.ibmec.album.model;

import br.edu.ibmec.album.domain.DadosCadastroCompositor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity(name = "Compositor")
@Table
@AllArgsConstructor
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id, nome")
public class Compositor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "compositor")
    private List<Musica> musicas;

    public Compositor(DadosCadastroCompositor dados){
        this.nome = dados.nome();
    }
}
