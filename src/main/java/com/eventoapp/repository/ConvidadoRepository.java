package com.eventoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventoapp.models.Convidado;
import com.eventoapp.models.Evento;

/**
 * Class ConvidadoRepository
 */
@Repository
public interface ConvidadoRepository extends JpaRepository<Convidado, Long>{
	/**
	 * 
	 * @param evento
	 * @return
	 */
	Iterable<Convidado> findByEvento(Evento evento);
	/**
	 * 
	 * @param cpf
	 * @return
	 */
	Convidado findByCpf(String cpf);
}
