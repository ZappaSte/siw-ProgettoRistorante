package it.uniroma3.siw.ristorante.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.ristorante.model.RigaOrdine;

public interface RigaOrdineRepository extends CrudRepository<RigaOrdine,Long>{
	
	public Optional<RigaOrdine> findById(Long id);

}
