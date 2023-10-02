package br.edu.ibmec.album.repository;

import br.edu.ibmec.album.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicaRepository extends JpaRepository<Musica, Long> {
}
