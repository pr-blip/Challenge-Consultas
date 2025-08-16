package com.aluraCursos.Challenge_Consultas.domain.Respuesta;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRespuesta(
        @NotBlank String mensaje,
        @NotBlank String topicoId,
        @NotNull Boolean Solucion
) {
}
