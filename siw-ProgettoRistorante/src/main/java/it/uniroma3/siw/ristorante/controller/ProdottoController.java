package it.uniroma3.siw.ristorante.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.uniroma3.siw.ristorante.model.Ordine;
import it.uniroma3.siw.ristorante.model.Prodotto;
import it.uniroma3.siw.ristorante.model.RigaOrdine;
import it.uniroma3.siw.ristorante.service.OrdineService;
import it.uniroma3.siw.ristorante.service.ProdottoService;
import it.uniroma3.siw.ristorante.service.RigaOrdineService;

@Controller
@SessionAttributes("ristoratoreCorrente")
public class ProdottoController {

	
	@Autowired
	public RigaOrdineService rigaOrdineService;
	
	@Autowired
	public ProdottoService prodottoService;
	
	@Autowired
	public OrdineService ordineService;
		
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value="/primi", method=RequestMethod.GET)
	public String showPrimi(Model model) {
		List<Integer> quantita = addInteger();
		model.addAttribute("quantita", quantita);
		List<Prodotto> primi = this.prodottoService.findAllPrimi();
		model.addAttribute("primi", primi);
		return "primi";
	}
	
	@RequestMapping(value="/secondi", method=RequestMethod.GET)
	public String showSecondi(Model model) {
		List<Integer> quantita = addInteger();
		model.addAttribute("quantita", quantita);
		List<Prodotto> secondi = this.prodottoService.findAllSecondi();
		model.addAttribute("secondi", secondi);
		return "secondi";
	}
	
	@RequestMapping(value="/contorni", method=RequestMethod.GET)
	public String showContorni(Model model) {
		List<Integer> quantita = addInteger();
		model.addAttribute("quantita", quantita);
		List<Prodotto> contorni = this.prodottoService.findAllContorni();
		model.addAttribute("contorni", contorni);
		return "contorni";
	}
	
	@RequestMapping(value="/pizze", method=RequestMethod.GET)
	public String showPizze(Model model) {
		List<Integer> quantita = addInteger();
		model.addAttribute("quantita", quantita);
		List<Prodotto> pizze = this.prodottoService.findAllPizze();
		model.addAttribute("pizze", pizze);
		return "pizze";
	}
	
	@RequestMapping(value="/dolci", method=RequestMethod.GET)
	public String showDolci(Model model) {
		List<Integer> quantita = addInteger();
		model.addAttribute("quantita", quantita);
		List<Prodotto> dolci = this.prodottoService.findAllDolci();
		model.addAttribute("dolci", dolci);
		return "dolci";
	}
	
	@RequestMapping(value="/vini", method=RequestMethod.GET)
	public String showVini(Model model) {
		List<Integer> quantita = addInteger();
		model.addAttribute("quantita", quantita);
		List<Prodotto> vini = this.prodottoService.findAllVini();
		model.addAttribute("vini", vini);
		return "vini";
	}
	
	@RequestMapping(value="/bevande", method=RequestMethod.GET)
	public String showBevande(Model model) {
		List<Integer> quantita = addInteger();
		model.addAttribute("quantita", quantita);
		List<Prodotto> bevande = this.prodottoService.findAllBevande();
		model.addAttribute("bevande", bevande);
		return "bevande";
	}
	
	
	
	/*Sceglie quale pagina del menu visualizzare */
	public String decidiPagDaRit(Prodotto prodotto,Model model) {
		if(prodotto.getCategoria().equals(Prodotto.PRIMO_CAT)) {
        	model.addAttribute("primi", prodottoService.findAllPrimi());
        	return "redirect:/primi";
        }
        else if(prodotto.getCategoria().equals(Prodotto.SECONDO_CAT)) {
        	model.addAttribute("secondi", prodottoService.findAllSecondi());
        	return "redirect:/secondi";
        }
        else if(prodotto.getCategoria().equals(Prodotto.CONTORNO_CAT)) {
        	model.addAttribute("contorni", prodottoService.findAllContorni());
        	return "redirect:/contorni";
        }
        else if(prodotto.getCategoria().equals(Prodotto.PIZZA_CAT)) {
        	model.addAttribute("pizze", prodottoService.findAllPizze());
        	return "redirect:/pizze";
        }
        else if(prodotto.getCategoria().equals(Prodotto.DOLCE_CAT)) {
        	model.addAttribute("dolci", prodottoService.findAllDolci());
        	return "redirect:/dolci";
        }
        else if(prodotto.getCategoria().equals(Prodotto.VINO_CAT)) {
        	model.addAttribute("vini", prodottoService.findAllVini());
        	return "redirect:/vini";
        }
        else if(prodotto.getCategoria().equals(Prodotto.BEVANDE_CAT)) {
        	model.addAttribute("bevande", prodottoService.findAllBevande());
        	return "redirect:/bevande";
        }
        return "redirect:/index";
    }
	
	
	
	/************************ELIMINAZIONE PRODOTTO************************/
	@RequestMapping(value = "prodotto/{id}/admin/eliminaProdotto", method = RequestMethod.GET)
    public String eliminaProdotto(@PathVariable("id") Long id, Model model) {
		model.addAttribute("prodotto", this.prodottoService.findById(id));
		return "admin/eliminaProdotto";		
    }    
    @RequestMapping(value = "prodotto/{id}/admin/eliminaProdotto", method = RequestMethod.POST)
    public String registerEliminaProdotto(@PathVariable("id") Long id, Model model) {
    	Prodotto prodotto = prodottoService.findById(id);
    	/* Cancella la collezione dal db */
        this.prodottoService.rimuovi(prodotto.getId());
        /* Se l'inserimento dei dati nella form è corretto, ritorna alla pagina di Admin */
        
       return this.decidiPagDaRit(prodotto, model);
    }
    
    
    
    /************************MODIFICA PRODOTTO************************/
    @RequestMapping(value = "prodotto/{id}/admin/modificaProdotto", method = RequestMethod.GET)
    public String modificaCollezione(@PathVariable("id") Long id, Model model) {
		model.addAttribute("prodotto", this.prodottoService.findById(id));
		return "admin/modificaProdotto";
    }
    
    @RequestMapping(value = "prodotto/{id}/admin/modificaProdotto", method = RequestMethod.POST)
    public String registerModificaProdotto(@PathVariable("id") Long id,@Validated @ModelAttribute("prodotto") Prodotto prodotto,
    				Model model) {    	
    	/*Aggiorna Modifiche Prodoto*/
    	prodottoService.update(prodotto, id);            
    	/* Se l'inserimento dei dati nella form è corretto, ritorna alla pagina di Admin */
    	return this.decidiPagDaRit(prodotto, model);
    }
	
    
    
    /************************AGGIUNTA PRODOTTO AL CARRELLO************************/
	@RequestMapping(value ="/prodotto/{id}/addProdottoCarrello", method=RequestMethod.POST)
	public String addProdottoCarrello(@PathVariable("id") Long id,
			@RequestParam(value = "quant") int quantita, Model model) {
		if(id==null) {
			return "error";
		}
		else {
			Ordine ordine = null;
			Prodotto prodotto = prodottoService.findById(id);
			RigaOrdine rigaOrdine = new RigaOrdine();
			if (session.getAttribute("carrello")==null){
				ordine = new Ordine();
				session.setAttribute("carrello", ordine);
			}
			else {
				 ordine = (Ordine) session.getAttribute("carrello");
			}
			rigaOrdine.setProdotto(prodotto);
			rigaOrdine.setQuantita(quantita);
			rigaOrdine.setSubTotale(rigaOrdine.calcolaSubTotale());
			rigaOrdine.setOrdine(ordine);
			//rigaOrdineService.save(rigaOrdine);
			ordine.addRigaOrdine(rigaOrdine);
			session.setAttribute("carrello", ordine);
			
			
			return decidiPagDaRit(prodotto, model);
		}
	}
	
	
	
	
	/************************MOSTRA CARRELLO************************/
	@RequestMapping(value="/carrello", method=RequestMethod.GET)
	public String showCarrello(Model model) {
		List<Integer> numTavoli = addInteger();
		model.addAttribute("numTavoli", numTavoli);
		if(session.getAttribute("carrello")==null) {
			return "carrelloVuoto";
		}
		else {
			Ordine ordine = (Ordine) session.getAttribute("carrello");
			ordine.setTotaleOrdine(this.calcolaTotaleOrdine(ordine.getRigheOrdine()));
			model.addAttribute("carrelloDaMostrare",ordine.getRigheOrdine());
			model.addAttribute("ordine", ordine);
			session.setAttribute("carrello", ordine);
			return "carrello";
		}
		
		
	}	
	
	/************************CONFERMA ORDINE************************/
	@RequestMapping(value="/confermaOrdine", method=RequestMethod.POST)
	public String confermaOrdine(Model model, @RequestParam("numTavolo") int numTavolo) {
		Ordine ordine = (Ordine) session.getAttribute("carrello");
		ordine.setDataOrdine(LocalDateTime.now());
		ordine.setNumTavolo(numTavolo);
		ordineService.save(ordine);
		model.addAttribute("ordineSuccess", ordine);
		model.addAttribute("carrelloDaMostrare",ordine.getRigheOrdine());
		model.addAttribute("ordine", ordine);
		session.invalidate();
		return "carrello";
	}
	
	
	
	
	
	
	
	
	
	
	
	public List<Integer> addInteger(){
		List<Integer> daRit = new ArrayList<>();
		Integer i=0;
		while( i<=10) {
			daRit.add(i);
			i++;
		}
		
		return daRit;
	}
    
	
	public BigDecimal calcolaTotaleOrdine(List<RigaOrdine> righeOrdine) {
		BigDecimal totale = new BigDecimal(0);
		for(RigaOrdine rigaOrdine : righeOrdine) {
			totale = totale.add(rigaOrdine.getSubTotale());
		}
		return totale;
	}
	 
}
