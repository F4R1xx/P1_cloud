package br.edu.ibmec.album.controller;

import br.edu.ibmec.album.NumeroMaximoMusicasService;
import br.edu.ibmec.album.domain.DadosCadastroMusica;
import br.edu.ibmec.album.domain.DadosDetalheMusica;
import br.edu.ibmec.album.model.Compositor;
import br.edu.ibmec.album.model.Musica;
import br.edu.ibmec.album.repository.CompositorRepository;
import br.edu.ibmec.album.repository.MusicaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("musica")
public class MusicaController {

    @Autowired
    MusicaRepository musicaRepository;

    @Autowired
    CompositorRepository compositorRepository;

    @Autowired
    NumeroMaximoMusicasService numeroMaximoMusicas;

    @PostMapping
    @Transactional
    public ResponseEntity criar(@RequestBody @Valid DadosCadastroMusica dados){

        Compositor compositor = compositorRepository.findById(dados.idCompositor()).get();
        numeroMaximoMusicas.validar(compositor);
        var musica = musicaRepository.save(new Musica(dados, compositor));

        return ResponseEntity.ok(new DadosDetalheMusica(musica));
    }

    @PutMapping
    @Transactional
    public ResponseEntity alterar(@RequestBody @Valid DadosDetalheMusica dados){

        Musica musica = musicaRepository.findById(dados.id()).get();
        musica.setNome(dados.nome());

        return ResponseEntity.ok(new DadosDetalheMusica(musica));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        musicaRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
