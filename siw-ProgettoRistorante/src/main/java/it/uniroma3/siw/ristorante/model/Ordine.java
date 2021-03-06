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
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Column(nullable = false)
	private LocalDateTime dataOrdine;
	
	private BigDecimal totaleOrdine;
	
	private int numTavolo;
	
	public Ordine(LocalDateTime dataOrdine, BigDecimal totaleOrdine) {
		this.dataOrdine = dataOrdine;
		this.totaleOrdine = totaleOrdine;
	}
	
	public Ordine() {
		this.righeOrdine = new ArrayList<>();
		this.totaleOrdine = new BigDecimal(0);
	}

	@OneToMany(mappedBy ="ordine", cascade= {CascadeType.MERGE})
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

	public int getNumTavolo() {
		return numTavolo;
	}

	public void setNumTavolo(int numTavolo) {
		this.numTavolo = numTavolo;
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
	
	
	public void modificaRigaOrdine(RigaOrdine rigaOrdine) {
		for(RigaOrdine rO : this.righeOrdine) {
			if(rO.getId().equals(rigaOrdine.getId())) {
				rO.setQuantita(rigaOrdine.getQuantita());
				rO.setSubTotale( rO.calcolaSubTotale());
			}
		}
	}
	
	public boolean removeRigaOrdine(RigaOrdine rigaOrdine) {
		if(righeOrdine.size()==1) {
			this.righeOrdine.remove(rigaOrdine);
			this.righeOrdine = new ArrayList<>();
			return true;
		}
		for(RigaOrdine rO : this.righeOrdine) {
			if(rO.getId().equals(rigaOrdine.getId())) {
				this.righeOrdine.remove(rO);
				return true;
			}
		}
		return false;
	}

	
}
