package it.uniroma3.siw.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ordine {
	
	/*DEFINIZIONE VARIABILI*/

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private LocalDateTime dataOrdine;
	
	private Float totaleOrdine;
	
	public Ordine(LocalDateTime dataOrdine, Float totaleOrdine) {
		this.dataOrdine = dataOrdine;
		this.totaleOrdine = totaleOrdine;
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

	public LocalDateTime getDataOrdine() {
		return dataOrdine;
	}

	public void setDataOrdine(LocalDateTime dataOrdine) {
		this.dataOrdine = dataOrdine;
	}

	public Float getTotaleOrdine() {
		return totaleOrdine;
	}

	public void setTotaleOrdine(Float totaleOrdine) {
		this.totaleOrdine = totaleOrdine;
	}

}
