package it.uniroma3.siw.ristorante.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.ristorante.model.Ristoratore;
import it.uniroma3.siw.ristorante.repository.RistoratoreRepository;


@Service
public class RistoratoreService {
	
	@Autowired
	private RistoratoreRepository ristoratoreRepository;
	
	@Transactional
	public Ristoratore findById(Long id) {
		Optional<Ristoratore> optional = ristoratoreRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else 
			return null;
	}

	@Transactional
	public boolean alreadyExists(Ristoratore ristoratore) {
		List<Ristoratore> ristoratori = this.ristoratoreRepository.findByNomeOrCognome(ristoratore.getNome(), ristoratore.getCognome());
		if (ristoratori.size() > 0)
			return true;
		else 
			return false;
	}

	public void save(Ristoratore ristoratore) {
		ristoratoreRepository.save(ristoratore);
	}

	public Object findAll() {
		return ristoratoreRepository.findAll();
	}

}
