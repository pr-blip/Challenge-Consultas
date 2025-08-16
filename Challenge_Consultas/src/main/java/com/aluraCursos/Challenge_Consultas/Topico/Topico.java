package com.aluraCursos.Challenge_Consultas.Topico;


import com.aluraCursos.Challenge_Consultas.Curso.Curso;
import com.aluraCursos.Challenge_Consultas.Respuesta.Respuesta;
import com.aluraCursos.Challenge_Consultas.Usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name="topicos")
@Entity(name="Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name= "usuario_id")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name= "curso_id")
    private Curso curso;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @OneToMany(mappedBy= "topico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Respuesta> respuestas=new ArrayList<>();


    public Topico(DatosRegistroTopico datos, Usuario autor, Curso curso) {
        this.id=null;
        this.titulo= datos.titulo();
        this.mensaje= datos.mensaje();
        this.estado=datos.estado();
        this.autor= autor;
        this.curso= curso;
        this.fechaCreacion= LocalDateTime.now();

    }

    public void actualizarInformaciones(@Valid DatosActualizacionTopico datos) {
        if(datos.titulo()!= null){
            this.titulo = datos.titulo();
        }
        if(datos.mensaje()!= null){
            this.mensaje = datos.mensaje();
        }
        if(datos.estado()!= null){
            this.estado = datos.estado();
        }
    }
}
