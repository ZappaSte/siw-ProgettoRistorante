package it.uniroma3.siw.ristorante.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.ristorante.model.Prodotto;
import it.uniroma3.siw.ristorante.repository.ProdottoRepository;

@Service
public class ProdottoService {

	@Autowired
	private ProdottoRepository prodottoRepository;
	
	@Transactional
	public Prodotto findById(Long id) {
		Optional<Prodotto> optional = prodottoRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else 
			return null;
	}

	@Transactional
	public boolean alreadyExists(Prodotto prodotto) {
		List<Prodotto> prodotti = this.prodottoRepository.findByNome(prodotto.getNome());
		if (prodotti.size() > 0)
			return true;
		else 
			return false;
	}

	public void save(Prodotto prodotto) {
		prodottoRepository.save(prodotto);
	}

	public Object findAll() {
		return prodottoRepository.findAll();
	}

	@Transactional
	public List<Prodotto> findAllPrimi() {
		List<Long> idProd  = this.prodottoRepository.findAllPrimi();
		List<Prodotto> prodotti = new ArrayList<>();
		for(Long id : idProd) {
			prodotti.add(this.findById(id));
		}

		return 	prodotti;
	}
	
}
