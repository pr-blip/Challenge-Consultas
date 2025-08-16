package com.aluraCursos.Challenge_Consultas.domain.Topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizacionTopico(
        @NotNull Long id,
        String titulo,
        String mensaje,
        Estado estado
) {
}
