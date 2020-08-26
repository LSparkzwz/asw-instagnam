package asw.instagnam.ricetteseguite.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RicetteService {

	@Autowired
	private RicetteRepository ricetteRepository;

	public Collection<Ricetta> getRicetteByAutore(String autore){
		Collection<Ricetta> ricette = ricetteRepository.findAllByAutore(autore);
		return ricette;
	};

	public Ricetta createRicetta(Long id, String autore, String titolo) {
		Ricetta ricetta = new Ricetta(id,autore,titolo);
		return ricetteRepository.save(ricetta);
	}
}
