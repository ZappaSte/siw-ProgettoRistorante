package it.uniroma3.siw.ristorante.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.ristorante.model.Ordine;

public interface OrdineRepository extends CrudRepository<Ordine, Long>{

	
	public Optional<Ordine> findById(Long id);

	//public List<Ordine> findByData(LocalDateTime dataOrdine);
}
