package com.forohub.api.domain.topico;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;



public record DatosRegistroTopico(@NotBlank String titulo,
    @NotBlank String mensaje, 
    @NotNull LocalDateTime fecha,
    @NotNull Boolean activo,
    @NotBlank String autor,
    @NotNull Curso curso) {
} 