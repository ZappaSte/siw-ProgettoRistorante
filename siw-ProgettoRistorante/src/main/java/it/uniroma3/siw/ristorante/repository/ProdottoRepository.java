package it.uniroma3.siw.ristorante.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
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
	
	@Query("SELECT id FROM Prodotto WHERE Categoria  = 'DOLCE'")
	public List<Long> findAllDolci();
	
	@Query("SELECT id FROM Prodotto WHERE Categoria  = 'VINO'")
	public List<Long> findAllVini();
	
	@Query("SELECT id FROM Prodotto WHERE Categoria  = 'BEVANDA'")
	public List<Long> findAllBevande();
	
	@Query("DELETE FROM Prodotto p WHERE p.id = ?1")
	@Modifying
	public int rimuoviProdottoById(Long idProdotto);
	
	@Query("UPDATE Prodotto SET nome = ?1, prezzo = ?2, descrizione = ?3, categoria = ?4 WHERE id = ?5")
	@Modifying
	public void saveOrUpdateProdotto(String titolo, BigDecimal prezzo, String descrizione, String categoria,Long id);
	
}
