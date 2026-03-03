package zus.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StambeniObjekat {

    private int idObjekta;
    private int idPlanete;
    private int cena;
    private int povrsina;
    private String planeta;


    public StambeniObjekat(int idObjekta, int idPlanete, int cena, int povrsina, String planeta) {
        this.idObjekta = idObjekta;
        this.idPlanete = idPlanete;
        this.cena = cena;
        this.povrsina = povrsina;
        this.planeta = planeta;
    }
}
