package it.uniroma3.siw.ristorante.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prodotto {
	
	public static final String PRIMO_CAT = "PRIMO";
	public static final String SECONDO_CAT = "SECONDO";
	public static final String CONTORNO_CAT = "CONTORNO";
	public static final String PIZZA_CAT = "PIZZA";
	public static final String DOLCE_CAT = "DOLCE";
	public static final String VINO_CAT = "VINO";
	public static final String BEVANDE_CAT = "BEVANDE";
	
	
	
	/*DEFINIZIONE VARIABILI*/

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private Float prezzo;
	
	private String descrizione;
	
	@Column(nullable = false)
	private String categoria;
	
	public Prodotto(String nome, Float prezzo, String descrizione, String categoria) {
		this.nome = nome;
		this.prezzo = prezzo;
		this.descrizione = descrizione;	
		this.categoria = categoria;
	}

	public Prodotto() {
		
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}