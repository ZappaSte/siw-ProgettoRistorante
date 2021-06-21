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
	public Prodotto inserisci(Prodotto prodotto) {
		return prodottoRepository.save(prodotto);
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
	public void rimuovi(Long id) {
		prodottoRepository.rimuoviProdottoById(id);		
	}
	
	@Transactional
	public void update(Prodotto prodotto, Long id) {
		prodottoRepository.saveOrUpdateProdotto(prodotto.getNome(),prodotto.getPrezzo(),
				prodotto.getDescrizione(),prodotto.getCategoria(), id);
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

	@Transactional
	public List<Prodotto> findAllSecondi() {
		List<Long> idProd  = this.prodottoRepository.findAllSecondi();
		List<Prodotto> prodotti = new ArrayList<>();
		for(Long id : idProd) {
			prodotti.add(this.findById(id));
		}

		return 	prodotti;
	}

	@Transactional
	public List<Prodotto> findAllContorni() {
		List<Long> idProd  = this.prodottoRepository.findAllContorni();
		List<Prodotto> prodotti = new ArrayList<>();
		for(Long id : idProd) {
			prodotti.add(this.findById(id));
		}

		return 	prodotti;
	}
	
	@Transactional
	public List<Prodotto> findAllPizze() {
		List<Long> idProd  = this.prodottoRepository.findAllPizze();
		List<Prodotto> prodotti = new ArrayList<>();
		for(Long id : idProd) {
			prodotti.add(this.findById(id));
		}

		return 	prodotti;
	}
	
	@Transactional
	public List<Prodotto> findAllDolci() {
		List<Long> idProd  = this.prodottoRepository.findAllDolci();
		List<Prodotto> prodotti = new ArrayList<>();
		for(Long id : idProd) {
			prodotti.add(this.findById(id));
		}

		return 	prodotti;
	}
	@Transactional
	public List<Prodotto> findAllVini() {
		List<Long> idProd  = this.prodottoRepository.findAllVini();
		List<Prodotto> prodotti = new ArrayList<>();
		for(Long id : idProd) {
			prodotti.add(this.findById(id));
		}

		return 	prodotti;
	}
	
	@Transactional
	public List<Prodotto> findAllBevande() {
		List<Long> idProd  = this.prodottoRepository.findAllBevande();
		List<Prodotto> prodotti = new ArrayList<>();
		for(Long id : idProd) {
			prodotti.add(this.findById(id));
		}

		return 	prodotti;
	}	
	
}
