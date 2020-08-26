package asw.instagnam.ricetteseguite.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class RicettaSeguita {

    @Id
    @GeneratedValue
    private Long id;
    private Long idRicetta;
    private String follower;
    private String autore;
    private String titolo;

    public RicettaSeguita(Long idRicetta, String follower, String autore, String titolo) {
        this();
        this.idRicetta = idRicetta;
        this.follower = follower;
        this.autore = autore;
        this.titolo = titolo;
    }


}