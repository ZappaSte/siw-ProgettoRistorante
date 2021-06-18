package it.uniroma3.siw.ristorante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.uniroma3.siw.ristorante.model.Prodotto;
import it.uniroma3.siw.ristorante.service.ProdottoService;

@Controller
@SessionAttributes("ristoratoreCorrente")
public class ProdottoController {

	
	@Autowired
	public ProdottoService prodottoService;
	
	@RequestMapping(value="/primi", method=RequestMethod.GET)
	public String showPrimi(Model model) {
		List<Prodotto> primi = this.prodottoService.findAllPrimi();
		model.addAttribute("primi", primi);
		return "primi";
	}
}
