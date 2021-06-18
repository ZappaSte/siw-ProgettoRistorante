package it.uniroma3.siw.ristorante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.ristorante.model.Prodotto;
import it.uniroma3.siw.ristorante.repository.ProdottoRepository;

@Component
public class DBpopulationRistorante implements ApplicationRunner{
	
	@Autowired
	private ProdottoRepository prodottoRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.addAll();
		
	}

	
	private void addAll() {
		
		System.out.print("Popolazione DB con Piatti");
		
		Prodotto p1 = new Prodotto();
		p1.setNome("Carbonara");
		p1.setPrezzo(7.5f);
		p1.setDescrizione("Carbonara con guanciale, uovo, pecorino");
		p1.setCategoria(Prodotto.PRIMO_CAT);
		
		Prodotto p2 = new Prodotto();
		p2.setNome("Amatriciana");
		p2.setPrezzo(7.5f);
		p2.setDescrizione("Amatriciana con pomodoro, guanciale");
		p2.setCategoria(Prodotto.PRIMO_CAT);
		
		
		/*Prodotto p3 = new Prodotto("Spaghetti alle Vongole",9.5f, "Spaghetti con vongole fresche", Prodotto.PRIMO_CAT);
		Prodotto p4 = new Prodotto("Risotto agli Scampi",9.5f, "Risotto con scampi freschi", Prodotto.PRIMO_CAT);*/
	
		
		
		prodottoRepository.save(p1);
		prodottoRepository.save(p2);
		//prodottoRepository.save(p3);
		//prodottoRepository.save(p4);
		
	}
}
