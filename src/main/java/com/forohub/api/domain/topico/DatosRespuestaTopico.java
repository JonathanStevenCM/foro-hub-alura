package com.forohub.api.domain.topico;

import java.time.LocalDateTime;


public record DatosRespuestaTopico(Long id,

    String titulo,

    String mensaje,

    LocalDateTime fecha,

    Boolean activo,

    String autor,
    
    String curso) {
} 