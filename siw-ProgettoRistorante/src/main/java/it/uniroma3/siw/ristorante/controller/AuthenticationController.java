package it.uniroma3.siw.ristorante.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("ristoratoreCorrente")
public class AuthenticationController {
	
	@RequestMapping(value = { "/", "/index" , "/index/**"}, method = RequestMethod.GET)
    public String index(Model model) {
			model.addAttribute("ristoratoreCorrente", model.getAttribute("ristoratoreCorrente"));
			return "index";
		
    }	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET) 
	public String showLoginForm (Model model) {
		return "loginForm";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET) 
	public String logout(Model model) {
		return "index";
	}


}
