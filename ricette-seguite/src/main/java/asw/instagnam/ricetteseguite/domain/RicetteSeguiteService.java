package asw.instagnam.ricetteseguite.domain;

import asw.instagnam.common.api.event.ConnessioneCreatedEvent;
import asw.instagnam.common.api.event.RicettaCreatedEvent;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service 
public class RicetteSeguiteService {

	@Autowired 
	private ConnessioniService connessioniService;

	@Autowired 
	private RicetteService ricetteService;

	@Autowired
	private RicetteSeguiteRepository ricetteSeguiteRepository;

	private final Logger logger = Logger.getLogger(RicetteSeguiteService.class.toString());

	public void createRicetteSeguite(Collection<RicettaSeguita> ricetteSeguite){
		ricetteSeguiteRepository.saveAll(ricetteSeguite);
	}

	/* Trova le ricette (in formato breve) degli utenti seguiti da utente. */ 
	public Collection<Ricetta> getRicetteSeguite(String utente) {
		Collection<RicettaSeguita> ricetteSeguite = ricetteSeguiteRepository.findAllByFollower(utente);
		return ricetteSeguite.stream().map(
				ricettaSeguita
						->
				new Ricetta(ricettaSeguita.getIdRicetta(),ricettaSeguita.getAutore(),ricettaSeguita.getTitolo())
		)
		.collect(Collectors.toList());
	}

	public void createConnessione(ConnessioneCreatedEvent event) {
		Long id = event.getId();
		String followed = event.getFollowed();
		String follower = event.getFollower();
		logger.info("Id: " + id + " Followed: " + followed + " Follower: " + follower);

		connessioniService.createConnessione(id,follower,followed);

		//ricavo tutte le ricette seguite dalla connessione appena creata
		Collection<Ricetta> ricetteByFollowed = ricetteService.getRicetteByAutore(followed);
		Collection<RicettaSeguita> ricetteSeguite = ricetteByFollowed.stream().map(
				ricetta
				->
				new RicettaSeguita(ricetta.getId(), follower, ricetta.getAutore(), ricetta.getTitolo())
		)
		.collect(Collectors.toList());

		createRicetteSeguite(ricetteSeguite);
	}

	public void createRicetta(RicettaCreatedEvent event){
		Long id = event.getId();
		String autore = event.getAutore();
		String titolo = event.getTitolo();
		logger.info("Id: " + id + " Autore: " + autore + " Titolo: " + titolo);

		ricetteService.createRicetta(id,autore,titolo);
		//aggiorno le ricette seguite di tutti gli utenti che seguono l'autore della ricetta creata
		Collection<Connessione> connessioniByFollowedAutore = connessioniService.getConnessioniByFollowed(autore);

		Collection<RicettaSeguita> ricetteSeguite = connessioniByFollowedAutore.stream().map(
				connessione
				->
				new RicettaSeguita(id, connessione.getFollower(), autore, titolo)
		)
		.collect(Collectors.toList());

		createRicetteSeguite(ricetteSeguite);
	}


	
}
