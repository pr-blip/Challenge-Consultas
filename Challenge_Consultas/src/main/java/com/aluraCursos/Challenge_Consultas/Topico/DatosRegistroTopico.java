package com.aluraCursos.Challenge_Consultas.Topico;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotNull Long usuarioId,
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull Long cursoId,
        @NotNull Estado estado

) {

}
