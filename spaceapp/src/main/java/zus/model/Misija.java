package zus.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Misija {
    int idMisije;
    String idPlanete;
    String nazivPl;
    String uspesna;

    public Misija(int idMisije, String idPlanete, String nazivPl, String uspesna) {
        this.idMisije = idMisije;
        this.idPlanete = idPlanete;
        this.nazivPl = nazivPl;
        this.uspesna = uspesna;
    }
}
