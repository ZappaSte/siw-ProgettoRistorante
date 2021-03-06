package it.uniroma3.siw.ristorante.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.ristorante.model.RigaOrdine;
import it.uniroma3.siw.ristorante.repository.RigaOrdineRepository;

@Service
public class RigaOrdineService {

	@Autowired
	private RigaOrdineRepository rigaOrdineRepository;
	
	@Transactional
	public RigaOrdine findById(Long id) {
		Optional<RigaOrdine> optional = rigaOrdineRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else 
			return null;
	}

	@Transactional
	public boolean alreadyExists(RigaOrdine rigaOrdine) {
		if (this.rigaOrdineRepository.findById(rigaOrdine.getId())!= null )
			return true;
		else 
			return false;
	}

	@Transactional
	public void save(RigaOrdine rigaOrdine) {
		rigaOrdineRepository.save(rigaOrdine);
	}

	public Object findAll() {
		return rigaOrdineRepository.findAll();
	}

	public void remove(RigaOrdine rigaOrdine) {
		rigaOrdineRepository.delete(rigaOrdine);
		
	}

	@Transactional
	public void saveOrUpdateQuantita(RigaOrdine rigaOrdine) {
		this.rigaOrdineRepository.saveOrUpdateQuantita(rigaOrdine.getQuantita(),rigaOrdine.getSubTotale(),rigaOrdine.getId());
		
	}
	
	@Transactional
	public void saveOrUpdateOrdine(RigaOrdine rigaOrdine) {
		this.rigaOrdineRepository.saveOrUpdateOrdine(rigaOrdine.getOrdine().getId(),rigaOrdine.getId());		
	}
	
	
	
	@Transactional
	public List<RigaOrdine> findAllById(Long idOrdine) {
		List<Long> idRiga  = this.rigaOrdineRepository.findAllById(idOrdine);
		List<RigaOrdine> righeOrdine = new ArrayList<>();
		for(Long id : idRiga) {
			righeOrdine.add(this.findById(id));
		}

		return 	righeOrdine;
	}
}
