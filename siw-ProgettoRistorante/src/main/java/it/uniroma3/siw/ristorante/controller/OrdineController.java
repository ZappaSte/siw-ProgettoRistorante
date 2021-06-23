package it.uniroma3.siw.ristorante.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.uniroma3.siw.ristorante.service.OrdineService;

@Controller
@SessionAttributes("ristoratoreCorrente")
public class OrdineController {
	
	@Autowired
	public OrdineService ordineService;
	
	/************************VISUALIZZA LISTA ORDINI************************/
    @RequestMapping(value = "ordini", method = RequestMethod.GET)
    public String getOrdini(Model model) {    	
    	model.addAttribute("ordini", this.ordineService.findAll());	
		return "admin/ordini";
    }
}
