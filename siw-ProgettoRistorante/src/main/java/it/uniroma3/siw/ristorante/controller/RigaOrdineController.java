package it.uniroma3.siw.ristorante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.uniroma3.siw.ristorante.service.RigaOrdineService;

@Controller
@SessionAttributes("ristoratoreCorrente")
public class RigaOrdineController {
	
	@Autowired
	public RigaOrdineService rigaOrdineService;
	
	/************************VISUALIZZA RIGHE ORDINE DI ORDINE************************/
    @RequestMapping(value = "admin/RigheOrdine/{id}", method = RequestMethod.GET)
    public String getRigheOrdineById(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("righeOrdine", this.rigaOrdineService.findAllById(id));	
		return "admin/ordine";
    }

}
