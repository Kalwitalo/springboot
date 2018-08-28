package br.com.techlead.springboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity //Anotação abstrai e faz a classe ser gerenciada pelo entity manager
@Data //Lombok diminue a verbosidade das classes, evitando get, set, toString, hashcode e equals
@NoArgsConstructor //Cria um construtor sem nenhum parâmetro
@AllArgsConstructor // Cria um construtor com todos os parâmetros
@Table(name = "tab_jogo") //Como o nome da tabela no banco é diferente colocamos esta anotação com o nome correto
public class Jogo {
    @EmbeddedId
    private JogoPK id;

    @Column(name = "pontos_casa") //Se quisermos um nome diferente podemos explicitar além de outras configurações
    private Integer pontosCasa;

    @Column(name = "pontos_visitante") //Se quisermos um nome diferente podemos explicitar além de outras configurações
    private Integer pontosVisitante;

    @Column(name = "data") //Se quisermos um nome diferente podemos explicitar além de outras configurações
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "pt-BR", timezone = "America/Belem")
    private Date data;
}
