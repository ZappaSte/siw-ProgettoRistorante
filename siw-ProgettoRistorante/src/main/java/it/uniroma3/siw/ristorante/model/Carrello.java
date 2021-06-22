package it.uniroma3.siw.ristorante.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Carrello {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/*@OneToMany(mappedBy ="carrello")
	private List<Prodotto> prodottiNelCarrello;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Prodotto> getProdottiNelCarrello() {
		return prodottiNelCarrello;
	}

	public void setProdottiNelCarrello(List<Prodotto> prodottiNelCarrello) {
		this.prodottiNelCarrello = prodottiNelCarrello;
	}*/
	
	
	
	
	

}
