package com.forohub.api.controller;

import java.lang.module.ResolutionException;
import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.forohub.api.domain.topico.DatosActualizarTopico;
import com.forohub.api.domain.topico.DatosListadoTopico;
import com.forohub.api.domain.topico.DatosRegistroTopico;
import com.forohub.api.domain.topico.DatosRespuestaTopico;
import com.forohub.api.domain.topico.Topico;
import com.forohub.api.domain.topico.TopicoRepository;

import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/topico")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;


    @PostMapping
    @Transient
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder) {
        Topico topico = topicoRepository.save(new Topico(datosRegistroTopico));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(),
        topico.getTitulo(), topico.getMensaje(), topico.getFecha(),topico.getActivo(), 
        topico.getAutor(),topico.getCurso().toString());
        URI uri = uriComponentsBuilder.path("topico/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(datosRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopico(Pageable paginacion) {

        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopico::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarMedico) {
        Topico topico = topicoRepository.getReferenceById(datosActualizarMedico.id());
        
        topico.actualizarDatos(datosActualizarMedico);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), 
        topico.getMensaje(), topico.getFecha(),topico.getActivo(),
        topico.getAutor(),topico.getCurso().toString()));

    }
    // DELETE LOGICO
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (optionalTopico.isPresent()) {
            topicoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> retornarDatosTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), 
        topico.getMensaje(), topico.getFecha(),topico.getActivo(),
        topico.getAutor(),topico.getCurso().toString());
        return ResponseEntity.ok(datosTopico);
    }
}
