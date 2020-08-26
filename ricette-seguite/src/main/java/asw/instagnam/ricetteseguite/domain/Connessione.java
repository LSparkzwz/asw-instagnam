package asw.instagnam.ricetteseguite.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data @NoArgsConstructor
public class Connessione {

	@Id
	private Long id; 
	private String follower; 
	private String followed;

	public Connessione(Long id, String follower, String followed) {
		this.id = id;
		this.follower = follower;
		this.followed = followed;
	}
}
