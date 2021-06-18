package it.uniroma3.siw.ristorante.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.ristorante.model.Prodotto;

public interface ProdottoRepository extends CrudRepository<Prodotto, Long>{

	public Optional<Prodotto> findById(Long id);

	public List<Prodotto> findByNome(String nome);

	
	@Query("SELECT id FROM Prodotto WHERE Categoria  = 'PRIMO'")
	public List<Long> findAllPrimi();

	@Query("SELECT id FROM Prodotto WHERE Categoria  = 'SECONDO'")
	public List<Long> findAllSecondi();

	
	@Query("SELECT id FROM Prodotto WHERE Categoria  = 'CONTORNO'")
	public List<Long> findAllContorni();
	
	@Query("SELECT id FROM Prodotto WHERE Categoria  = 'PIZZA'")
	public List<Long> findAllPizze();
	
	@Query("SELECT id FROM Prodotto WHERE Categoria  = 'BEVANDE'")
	public List<Long> findAllBevande();
	
	@Query("SELECT id FROM Prodotto WHERE Categoria  = 'VINO'")
	public List<Long> findAllVini();
}
