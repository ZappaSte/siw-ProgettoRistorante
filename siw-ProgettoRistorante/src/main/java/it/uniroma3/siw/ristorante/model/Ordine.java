package it.uniroma3.siw.ristorante.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	
	@OneToMany(mappedBy ="ordine", cascade= {CascadeType.ALL})
	private List<RigaOrdine> righeOrdine;

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

	public List<RigaOrdine> getRigheOrdine() {
		return righeOrdine;
	}

	public void setRigheOrdine(List<RigaOrdine> righeOrdine) {
		this.righeOrdine = righeOrdine;
	}
	
	

}