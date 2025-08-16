package com.aluraCursos.Challenge_Consultas.domain.Topico;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository  extends JpaRepository <Topico, Long>{
    boolean existsByTituloAndMensaje(String titulo,String mensaje);
}
