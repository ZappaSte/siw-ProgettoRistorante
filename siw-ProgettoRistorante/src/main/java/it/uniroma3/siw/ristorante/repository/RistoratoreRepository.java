package it.uniroma3.siw.ristorante.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.ristorante.model.Ristoratore;

public interface RistoratoreRepository extends CrudRepository<Ristoratore,Long>{

	
	public Optional<Ristoratore>  findById(Long id);

	public List<Ristoratore> findByNomeOrCognome(String nome, String cognome);
	
}
