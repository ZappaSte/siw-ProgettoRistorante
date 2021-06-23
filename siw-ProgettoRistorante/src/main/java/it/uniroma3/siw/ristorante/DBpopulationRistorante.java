package it.uniroma3.siw.ristorante;

import java.math.BigDecimal;

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
		p1.setPrezzo(new BigDecimal("7.5"));
		p1.setDescrizione("Carbonara con guanciale, uovo, pecorino");
		p1.setCategoria(Prodotto.PRIMO_CAT);
		
		Prodotto p2 = new Prodotto();
		p2.setNome("Amatriciana");
		p2.setPrezzo(new BigDecimal("7.5"));
		p2.setDescrizione("Amatriciana con pomodoro, guanciale");
		p2.setCategoria(Prodotto.PRIMO_CAT);
		
		
		Prodotto p3 = new Prodotto("Spaghetti alle Vongole",new BigDecimal("9.5"), "Spaghetti con vongole fresche", Prodotto.PRIMO_CAT);
		Prodotto p4 = new Prodotto("Risotto agli Scampi",new BigDecimal("9.5"), "Risotto con scampi freschi", Prodotto.PRIMO_CAT);
		Prodotto p5 = new Prodotto("Scaloppine al Limone",new BigDecimal("9.5"), "Scaloppine di pollo al limone", Prodotto.SECONDO_CAT);
		Prodotto p6 = new Prodotto("Bistecca di Manzo",new BigDecimal("22"), "Bistecca di manzo, taglio fiorentina", Prodotto.SECONDO_CAT);
		Prodotto p7 = new Prodotto("Frittura di Mare",new BigDecimal("15"), "Frittura di pesce con calamari e moscardini", Prodotto.SECONDO_CAT);
		Prodotto p8 = new Prodotto("Patate al Forno",new BigDecimal("5"), "Patate al forno con rosmarino", Prodotto.CONTORNO_CAT);
		Prodotto p9 = new Prodotto("Cicoria Ripassata",new BigDecimal("5"), "Cicoria Ripassata con peperoncino", Prodotto.CONTORNO_CAT);
		Prodotto p10 = new Prodotto("Insalata",new BigDecimal("5"), "Insalatya di lattuga, carote e finocchi", Prodotto.CONTORNO_CAT);
		Prodotto p11 = new Prodotto("Polpo con patate",new BigDecimal("12"), "Polpo con patate", Prodotto.SECONDO_CAT);
		Prodotto p12 = new Prodotto("Coca Cola",new BigDecimal("4"), "1.5LT", Prodotto.BEVANDE_CAT);
		Prodotto p13 = new Prodotto("Sprite",new BigDecimal("2"), "33cL", Prodotto.BEVANDE_CAT);
		Prodotto p14 = new Prodotto("Vino Rosso",new BigDecimal("18"), "Vino rosso dei castelli", Prodotto.VINO_CAT);
		Prodotto p15 = new Prodotto("Falanghina",new BigDecimal("18"), "Vino bianco, falanghina beneventana", Prodotto.VINO_CAT);
		Prodotto p16 = new Prodotto("Montepulciano d'Abruzzo",new BigDecimal("16"), "Vino rosso tipico abruzzese, consigliato con la carne", Prodotto.VINO_CAT);
		Prodotto p17 = new Prodotto("Acqua Naturale",new BigDecimal("2"), "Acqua 1.5Lt", Prodotto.BEVANDE_CAT);
		Prodotto p18 = new Prodotto("Acqua Frizzante",new BigDecimal("2"), "Acqua 1.5Lt", Prodotto.BEVANDE_CAT);
		Prodotto p19 = new Prodotto("Coca Cola",new BigDecimal("2.5"), "Coca Cola 1.5Lt", Prodotto.BEVANDE_CAT);
		Prodotto p20 = new Prodotto("Coca Cola Lattina",new BigDecimal("1.5"), "Coca Cola 33cL", Prodotto.BEVANDE_CAT);
		Prodotto p21 = new Prodotto("Fanta",new BigDecimal("2.5"), "Fanta Aranciata 1.5Lt", Prodotto.BEVANDE_CAT);
		Prodotto p22 = new Prodotto("Millefoglie",new BigDecimal("4"), "Dolce millefoglie con crema ai frutti di bosco", Prodotto.DOLCE_CAT);
		Prodotto p23 = new Prodotto("Tiramisu",new BigDecimal("4"), "Tiramisu con caffe e cacao", Prodotto.DOLCE_CAT);
		Prodotto p24 = new Prodotto("Passerina",new BigDecimal("18"), "Vino bianco Marchigiano, consigliato per il pesce", Prodotto.VINO_CAT);
		Prodotto p25 = new Prodotto("Torta della Nonna",new BigDecimal("4"), "Torta della nonna con crema pasticciera e gocce di cioccolato", Prodotto.DOLCE_CAT);
		Prodotto p26 = new Prodotto("Marinara",new BigDecimal("4.5"), "Pizza con pomodoro e origano", Prodotto.PIZZA_CAT);
		Prodotto p27 = new Prodotto("Margherita",new BigDecimal("5"), "Pizza con pomodoro, moozarella e basilico", Prodotto.PIZZA_CAT);
		Prodotto p28 = new Prodotto("Patate e Wurtsel",new BigDecimal("6"), "Pizza con patate, wurtsel e mozzarella, base bianca", Prodotto.PIZZA_CAT);
		Prodotto p29 = new Prodotto("Boscaiola",new BigDecimal("6.5"), "Pizza con funghi, salsiccia e mozzarella ", Prodotto.PIZZA_CAT);
		Prodotto p30 = new Prodotto("Fiori e Alici",new BigDecimal("6.5"), "Pizza con fiori, alici e mozzarella, base bianca", Prodotto.PIZZA_CAT);
		Prodotto p31 = new Prodotto("Vegetale",new BigDecimal("7"), "Pizza margherita con zucchine, peperoni e melanzane grigliate", Prodotto.PIZZA_CAT);
		Prodotto p32 = new Prodotto("Montanara",new BigDecimal("10"), "Pizza margerita con speck, provola e salsa tartufata", Prodotto.PIZZA_CAT);
		Prodotto p33 = new Prodotto("Napoli",new BigDecimal("6"), "Pizza margherita con alici", Prodotto.PIZZA_CAT);
		Prodotto p34 = new Prodotto("Calzone rustico",new BigDecimal("8"), "Calzone rusticon con mozzarella, prosciutto crudo e funghi", Prodotto.PIZZA_CAT);
		Prodotto p35 = new Prodotto("Terra e Mare",new BigDecimal("8"), "Pizza con mozzarella, zucchine, gamberetti e salsa rosa", Prodotto.PIZZA_CAT);
		
		
		
		
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
		prodottoRepository.save(p16);
		prodottoRepository.save(p17);
		prodottoRepository.save(p18);
		prodottoRepository.save(p19);
		prodottoRepository.save(p20);
		prodottoRepository.save(p21);
		prodottoRepository.save(p22);
		prodottoRepository.save(p23);
		prodottoRepository.save(p24);
		prodottoRepository.save(p25);
		prodottoRepository.save(p26);
		prodottoRepository.save(p27);
		prodottoRepository.save(p28);
		prodottoRepository.save(p29);
		prodottoRepository.save(p30);
		prodottoRepository.save(p31);
		prodottoRepository.save(p32);
		prodottoRepository.save(p33);
		prodottoRepository.save(p34);
		prodottoRepository.save(p35);
		
		
		
		
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
