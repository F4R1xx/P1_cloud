package br.edu.ibmec.album.domain;

import br.edu.ibmec.album.model.Musica;

public record DadosDetalheMusica(Long id, String nome) {

    public DadosDetalheMusica(Musica musica){
        this(musica.getId(), musica.getNome());
    }
}
