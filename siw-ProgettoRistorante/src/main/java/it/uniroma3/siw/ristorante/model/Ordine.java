package it.uniroma3.siw.ristorante.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
	
	private BigDecimal totaleOrdine;
	
	public Ordine(LocalDateTime dataOrdine, BigDecimal totaleOrdine) {
		this.dataOrdine = dataOrdine;
		this.totaleOrdine = totaleOrdine;
	}
	
	public Ordine() {
		this.righeOrdine = new ArrayList<>();
		this.totaleOrdine = new BigDecimal(0);
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

	public BigDecimal getTotaleOrdine() {
		return totaleOrdine;
	}

	public void setTotaleOrdine(BigDecimal totaleOrdine) {
		this.totaleOrdine = totaleOrdine;
	}

	public List<RigaOrdine> getRigheOrdine() {
		return righeOrdine;
	}

	public void setRigheOrdine(List<RigaOrdine> righeOrdine) {
		for(RigaOrdine rigaOrdine : righeOrdine) {
			rigaOrdine.calcolaSubTotale();
			this.righeOrdine.add(rigaOrdine);
		}
	}
	
	public void addRigaOrdine(RigaOrdine rigaOrdine) {
		this.righeOrdine.add(rigaOrdine);
	}
	
	
	

}
