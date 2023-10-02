package br.edu.ibmec.album.domain;

import br.edu.ibmec.album.model.Compositor;
import br.edu.ibmec.album.model.Musica;

import java.util.List;
import java.util.stream.Collectors;

public record DadosDetalheCompositor(Long id, String nome, List<DadosDetalheMusica> musicas) {

    public DadosDetalheCompositor(Compositor compositor){
        this(compositor.getId(), compositor.getNome(), compositor.getMusicas().stream().map(DadosDetalheMusica::new).collect(Collectors.toList()));
    }
}
