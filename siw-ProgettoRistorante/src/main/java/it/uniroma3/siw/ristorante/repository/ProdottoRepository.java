package it.uniroma3.siw.ristorante.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.ristorante.model.Prodotto;

public interface ProdottoRepository extends CrudRepository<Prodotto, Long>{

	public Optional<Prodotto> findById(Long id);

	public List<Prodotto> findByNome(String nome);
}
