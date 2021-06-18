package it.uniroma3.siw.ristorante.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.uniroma3.siw.ristorante.model.Prodotto;
import it.uniroma3.siw.ristorante.service.ProdottoService;

@Controller
@SessionAttributes("ristoratoreCorrente")
public class ProdottoController {

	
	private List<Prodotto> carrello = new ArrayList<>();
	
	@Autowired
	public ProdottoService prodottoService;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value="/primi", method=RequestMethod.GET)
	public String showPrimi(Model model) {
		List<Prodotto> primi = this.prodottoService.findAllPrimi();
		model.addAttribute("primi", primi);
		return "primi";
	}
	
	@RequestMapping(value="/secondi", method=RequestMethod.GET)
	public String showSecondi(Model model) {
		List<Prodotto> secondi = this.prodottoService.findAllSecondi();
		model.addAttribute("secondi", secondi);
		return "primi";
	}
	
	@RequestMapping(value="/contorni", method=RequestMethod.GET)
	public String showContorni(Model model) {
		List<Prodotto> contorni = this.prodottoService.findAllContorni();
		model.addAttribute("contorni", contorni);
		return "primi";
	}
	
	@RequestMapping(value="/bevande", method=RequestMethod.GET)
	public String showBevande(Model model) {
		List<Prodotto> bevande = this.prodottoService.findAllBevande();
		model.addAttribute("bevande", bevande);
		return "primi";
	}
	
	@RequestMapping(value="/pizze", method=RequestMethod.GET)
	public String showPizze(Model model) {
		List<Prodotto> pizze = this.prodottoService.findAllPizze();
		model.addAttribute("pizze", pizze);
		return "primi";
	}
	
	@RequestMapping(value="/vini", method=RequestMethod.GET)
	public String showVini(Model model) {
		List<Prodotto> vini = this.prodottoService.findAllVini();
		model.addAttribute("vini", vini);
		return "primi";
	}
	
	@RequestMapping(value ="/addProdottoCarrello/{id}", method=RequestMethod.POST)
	public String addProdottoCarrello(@PathVariable("id") Long id, Model model) {
		if(id==null) {
			return "error";
		}
		else {
			Prodotto prodotto= prodottoService.findById(id);
			if (session.getAttribute("carrello")==null){
				session.setAttribute("carrello", carrello);
			}

			carrello.add(prodotto);
			return "redirect:";
		}
	}

}
