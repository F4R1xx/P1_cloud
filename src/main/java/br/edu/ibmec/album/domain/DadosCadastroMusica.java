package br.edu.ibmec.album.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroMusica(

        @NotBlank
        String nome,

        @NotNull
        Long idCompositor
) {
}
