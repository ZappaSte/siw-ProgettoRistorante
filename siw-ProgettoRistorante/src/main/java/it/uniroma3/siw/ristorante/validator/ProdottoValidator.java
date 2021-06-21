package it.uniroma3.siw.ristorante.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.ristorante.model.Prodotto;
import it.uniroma3.siw.ristorante.service.ProdottoService;

@Component
public class ProdottoValidator implements Validator{

	@Autowired
	private ProdottoService prodottoService;
	

	@Override
	public boolean supports(Class<?> clazz) {
		return ProdottoService.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome","required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prezzo","required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descrizione","required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoria","required");
		if(this.prodottoService.alreadyExists((Prodotto)target)){
			errors.reject("duplicato");
		}
		
	}
}
