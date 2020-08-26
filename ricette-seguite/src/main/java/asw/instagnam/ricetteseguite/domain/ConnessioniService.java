package asw.instagnam.ricetteseguite.domain;

import asw.instagnam.common.api.event.ConnessioneCreatedEvent;
import asw.instagnam.common.api.event.DomainEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ConnessioniService {

	@Autowired
	private ConnessioniRepository connessioniRepository;

	public Collection<Connessione> getConnessioniByFollower(String follower) {
		Collection<Connessione> connessioni = connessioniRepository.findAllByFollower(follower);
		return connessioni;
	}

	public Collection<Connessione> getConnessioniByFollowed(String follower) {
		Collection<Connessione> connessioni = connessioniRepository.findAllByFollowed(follower);
		return connessioni;
	}

	public Connessione createConnessione(Long id, String follower, String followed) {
		Connessione connessione = new Connessione(id, follower, followed);
		return connessioniRepository.save(connessione);
	}


	
}
