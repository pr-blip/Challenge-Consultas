package com.aluraCursos.Challenge_Consultas.Respuesta;

import com.aluraCursos.Challenge_Consultas.Topico.Topico;
import com.aluraCursos.Challenge_Consultas.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name="respuestas")
@Entity(name="Respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    private LocalDateTime fechaCreacion=LocalDateTime.now();
    private Boolean solucion;

    @ManyToOne
    @JoinColumn(name= "topico_id")
    private Topico topico;

    @ManyToOne
    @JoinColumn(name="autor_id")
    private Usuario autor;

    public Respuesta(DatosRespuesta datos, Topico topico, Usuario autor){
        this.mensaje= datos.mensaje();
        this.solucion=datos.Solucion();
        this.topico=topico;
        this.autor=autor;
    }


}
