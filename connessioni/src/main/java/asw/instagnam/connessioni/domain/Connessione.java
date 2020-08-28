package asw.instagnam.connessioni.domain;

import javax.persistence.*; 

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data @NoArgsConstructor
public class Connessione {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String follower; 
	private String followed; 
	
	public Connessione(String follower, String followed) {
		this(); 
		this.follower = follower; 
		this.followed = followed; 
	}
	
}
