package br.edu.ibmec.album;

import br.edu.ibmec.album.model.Compositor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class NumeroMaximoMusicasService {

    private static final int MAX_MUSICAS = 5;

    public void validar(Compositor compositor){

        if (compositor == null){
            throw new RuntimeException("Compositor não encontrado.");
        }

        if (compositor.getMusicas().size() >= MAX_MUSICAS){
            throw new RuntimeException(MessageFormat.format("Número máximo de músicas atingido ({0})", MAX_MUSICAS));
        }
    }
}
