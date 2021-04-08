package com.eventoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventoapp.models.Evento;

/**
 * Class EventoRepository
 */
@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>{
	/**
	 * 
	 * @param codigo
	 * @return
	 */
	Evento findByCodigo(long codigo);
}
