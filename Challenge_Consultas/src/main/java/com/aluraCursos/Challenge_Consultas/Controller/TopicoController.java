package com.aluraCursos.Challenge_Consultas.Controller;


import com.aluraCursos.Challenge_Consultas.domain.Curso.CursoRepository;
import com.aluraCursos.Challenge_Consultas.domain.Perfil.PerfilRepository;
import com.aluraCursos.Challenge_Consultas.domain.Respuesta.RespuestaRepository;
import com.aluraCursos.Challenge_Consultas.domain.Topico.*;
import com.aluraCursos.Challenge_Consultas.domain.Usuario.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;



@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    @Transactional
    @PostMapping
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroTopico datos, UriComponentsBuilder uriComponentsBuilder){

        //Verifica si ya existe un tópico con el mismo título y mensaje
        if(repository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())){
            return ResponseEntity
                    .badRequest()
                    .body("Ya existe un tópico con ese título y mensaje");

        }

        var autor = usuarioRepository.findById(datos.usuarioId())
                .orElseThrow(()->new EntityNotFoundException("Usuario no encontrado"));

        var curso= cursoRepository.findById(datos.cursoId())
                .orElseThrow(()-> new EntityNotFoundException("Curso no encontrado"));

        var topico= new Topico(datos, autor, curso);
        repository.save(topico);
        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DatosDetalleTopico(topico));

    }
    //Endpoint para listar todos los tópicos
    @GetMapping
    public ResponseEntity<Page<DatosListaTopico>> listar(@PageableDefault(size=10, sort = {"titulo"}) Pageable paginacion){
        var page = repository.findAll(paginacion).map(DatosListaTopico::new);

        return ResponseEntity.ok(page);

    }

    @Transactional
    @PutMapping
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizacionTopico datos){
        var topico = repository.getReferenceById(datos.id());
        topico.actualizarInformaciones(datos);

        return ResponseEntity.ok(new DatosDetalleTopico(topico));

    }
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable Long id){
        var topico = repository.getReferenceById(id);

        return ResponseEntity.ok(new DatosDetalleTopico(topico));

    }
}
