package com.forohub.api.domain.topico;

import java.time.LocalDateTime;



public record DatosListadoTopico(Long id,
    String titulo, 
    String mensaje, 
    LocalDateTime fechaDeCreacion, 
    Boolean activo,  
    String autor,
    String curso) {

        public DatosListadoTopico(Topico topico) {
            this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha(),topico.getActivo(), topico.getAutor(),topico.getCurso().toString());
        }
} 
