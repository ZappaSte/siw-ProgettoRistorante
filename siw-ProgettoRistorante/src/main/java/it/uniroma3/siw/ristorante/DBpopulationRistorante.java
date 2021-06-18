package it.uniroma3.siw.ristorante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.ristorante.model.Credentials;
import it.uniroma3.siw.ristorante.model.Prodotto;
import it.uniroma3.siw.ristorante.model.Ristoratore;
import it.uniroma3.siw.ristorante.repository.ProdottoRepository;
import it.uniroma3.siw.ristorante.repository.RistoratoreRepository;
import it.uniroma3.siw.ristorante.service.CredentialsService;

@Component
public class DBpopulationRistorante implements ApplicationRunner{
	
	@Autowired
	private ProdottoRepository prodottoRepository;
	
	@Autowired
	private RistoratoreRepository ristoratoreRepository;
	
	@Autowired
	private CredentialsService credentialsService;

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
		
		
		Prodotto p3 = new Prodotto("Spaghetti alle Vongole",9.5f, "Spaghetti con vongole fresche", Prodotto.PRIMO_CAT);
		Prodotto p4 = new Prodotto("Risotto agli Scampi",9.5f, "Risotto con scampi freschi", Prodotto.PRIMO_CAT);
		Prodotto p5 = new Prodotto("Scaloppine al Limone",12.0f, "Scaloppine di pollo al limone", Prodotto.SECONDO_CAT);
		Prodotto p6 = new Prodotto("Bistecca di Manzo",18f, "Bistecca di manzo, taglio fiorentina", Prodotto.SECONDO_CAT);
		Prodotto p7 = new Prodotto("Frittura di Mare",15f, "Frittura di pesce con calamari e moscardini", Prodotto.SECONDO_CAT);
		Prodotto p8 = new Prodotto("Patate al Forno",7f, "Patate al forno con rosmarino", Prodotto.CONTORNO_CAT);
		Prodotto p9 = new Prodotto("Cicoria Ripassata",5f, "Cicoria Ripassata con peperoncino", Prodotto.CONTORNO_CAT);
		Prodotto p10 = new Prodotto("Insalata",5f, "Insalatya di lattuga, carote e finocchi", Prodotto.CONTORNO_CAT);
		Prodotto p11 = new Prodotto("Polpo con patate", 12f, "Polpo con patate", Prodotto.SECONDO_CAT);
		Prodotto p12 = new Prodotto("Coca Cola",2.5f, "1.5LT", Prodotto.BEVANDE_CAT);
		Prodotto p13 = new Prodotto("Sprite",9.5f, "33cL", Prodotto.BEVANDE_CAT);
		Prodotto p14 = new Prodotto("Vino Rosso",9.5f, "Vino rosso dei castelli", Prodotto.VINO_CAT);
		Prodotto p15 = new Prodotto("Falanghina",9.5f, "Vino bianco, falanghina beneventana", Prodotto.VINO_CAT);
	
		
		
		prodottoRepository.save(p1);
		prodottoRepository.save(p2);
		prodottoRepository.save(p3);
		prodottoRepository.save(p4);
		prodottoRepository.save(p5);
		prodottoRepository.save(p6);
		prodottoRepository.save(p7);
		prodottoRepository.save(p8);
		prodottoRepository.save(p9);
		prodottoRepository.save(p10);
		prodottoRepository.save(p11);
		prodottoRepository.save(p12);
		prodottoRepository.save(p13);
		prodottoRepository.save(p14);
		prodottoRepository.save(p15);
		
		
		Ristoratore r1 = new Ristoratore();
		r1.setNome("Alessandro");
		r1.setCognome("Borghese");
		r1.setEmail("a.borghese@4rist.com");
		r1.setTelefono("3332954366");
		
		Credentials c1 = new Credentials();
		c1.setUsername("admin");
		c1.setPassword("admin");
		c1.setRole("ADMIN");
		c1.setRistoratore(r1);
		
		ristoratoreRepository.save(r1);
		
		credentialsService.saveCredentials(c1);
		
		
		
	}
}
