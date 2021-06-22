package it.uniroma3.siw.ristorante.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.uniroma3.siw.ristorante.service.OrdineService;
import it.uniroma3.siw.ristorante.service.RigaOrdineService;

@Controller
@SessionAttributes("ristoratoreCorrente")
public class OrdineController {
	
	@Autowired
	public OrdineService ordineService;
	
	@Autowired
	public RigaOrdineService rigaOrdineService;
	
	
	/************************VISUALIZZA LISTA ORDINI************************/
    @RequestMapping(value = "admin/ordini", method = RequestMethod.GET)
    public String getOrdini(Model model) {    	
    	model.addAttribute("ordini", this.ordineService.findAll());	
		return "admin/ordini";
    }
    
    /************************VISUALIZZA ORDINE************************/
    @RequestMapping(value = "admin/RigaOrdine/{id}", method = RequestMethod.GET)
    public String getRigaOrdine(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("ordine", this.ordineService.findById(id));
    	model.addAttribute("rigaOrdine", this.ordineService.findAll());	
		return "admin/ordine";
    }

}
