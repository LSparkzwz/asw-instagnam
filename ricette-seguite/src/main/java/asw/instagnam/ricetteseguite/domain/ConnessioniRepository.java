package asw.instagnam.ricetteseguite.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ConnessioniRepository extends CrudRepository<Connessione, Long> {

    //followed = utente con follower
    public Collection<Connessione> findAllByFollowed(String followed);

    public Collection<Connessione> findAllByFollower(String followed);

}
