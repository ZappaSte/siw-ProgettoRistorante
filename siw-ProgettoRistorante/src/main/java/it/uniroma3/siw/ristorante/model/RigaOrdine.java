package it.uniroma3.siw.ristorante.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RigaOrdine {

	/*DEFINIZIONE VARIABILI*/

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private int quantita;

	
	@ManyToOne
	private Ordine ordine;
	
	@ManyToOne
	private Prodotto prodotto;
	
	

	public RigaOrdine(int quantita, Prodotto prodotto) {
		this.quantita = quantita;
		this.prodotto = prodotto;
	}
	
	public RigaOrdine(int quantita) {
		this.quantita = quantita;
	}
	

	public RigaOrdine() {
		// TODO Auto-generated constructor stub
	}

	/****************************************************************************************************/
	/******************************************METODI GET E SET******************************************/
	/****************************************************************************************************/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public Ordine getOrdine() {
		return ordine;
	}

	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}

	public Prodotto getProdotto() {
		return prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}
	
	
	
	
}
