package br.edu.ibmec.album.controller;

import br.edu.ibmec.album.domain.DadosCadastroCompositor;
import br.edu.ibmec.album.domain.DadosDetalheCompositor;
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
@RequestMapping("compositor")
public class CompositorController {

    @Autowired
    private CompositorRepository compositorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity criar(@RequestBody @Valid DadosCadastroCompositor dados) {
        var compositor = compositorRepository.save(new Compositor(dados));
        return ResponseEntity.ok(compositor);
    }

    @GetMapping
    public ResponseEntity listar(){
        return ResponseEntity.ok(compositorRepository.findAll().stream().map(DadosDetalheCompositor::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity consultar(@PathVariable Long id){
        var compositor = compositorRepository.findById(id).get();
        return ResponseEntity.ok(new DadosDetalheCompositor(compositor));
    }
}
