package com.forohub.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.forohub.api.domain.topico.DatosListadoTopico;
import com.forohub.api.domain.topico.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

    Page<DatosListadoTopico> findByActivoTrue(Pageable paginacion);

}
