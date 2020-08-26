package asw.instagnam.ricetteseguite.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface RicetteSeguiteRepository extends CrudRepository<RicettaSeguita, Long> {

    public Collection<RicettaSeguita> findAllByFollower(String follower);

}
