package it.uniroma3.siw.ristorante.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.ristorante.model.RigaOrdine;

public interface RigaOrdineRepository extends CrudRepository<RigaOrdine,Long>{
	
	public Optional<RigaOrdine> findById(Long id);

	
	@Query("UPDATE RigaOrdine SET quantita = ?1, subTotale = ?2 WHERE id = ?3")
	@Modifying
	public void saveOrUpdateQuantita(int quantita,BigDecimal subTotale, Long id);

}
