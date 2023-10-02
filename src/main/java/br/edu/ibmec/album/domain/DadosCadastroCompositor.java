package br.edu.ibmec.album.domain;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCompositor(
        @NotBlank
        String nome
) {
}
