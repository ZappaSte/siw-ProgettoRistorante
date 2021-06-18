package it.uniroma3.siw.ristorante.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.ristorante.model.Ordine;
import it.uniroma3.siw.ristorante.repository.OrdineRepository;

@Service
public class OrdineService {

	
	@Autowired
	private OrdineRepository ordineRepository;
	
	@Transactional
	public Ordine findById(Long id) {
		Optional<Ordine> optional = ordineRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else 
			return null;
	}

	/*@Transactional
	public boolean alreadyExists(Ordine ordine) {
		List<Ordine> ordini = this.ordineRepository.findByData(ordine.getDataOrdine());
		if (ordini.size() > 0)
			return true;
		else 
			return false;
	}*/

	public void save(Ordine ordine) {
		ordineRepository.save(ordine);
	}

	public Object findAll() {
		return ordineRepository.findAll();
	}
}
