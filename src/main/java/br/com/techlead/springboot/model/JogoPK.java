package br.com.techlead.springboot.model;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
public class JogoPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_time_casa", referencedColumnName = "id", nullable = false)
    private Time timeCasa;

    @ManyToOne
    @JoinColumn(name = "id_time_visitante", referencedColumnName = "id", nullable = false)
    private Time timeVisitante;

    public JogoPK() {
    }

    public JogoPK(Integer idTimeCasa, Integer idTimeVisitante) {
        this.timeCasa = new Time(idTimeCasa);
        this.timeVisitante = new Time(idTimeVisitante);
    }
}
