package br.com.techlead.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity //Anotação abstrai e faz a classe ser gerenciada pelo entity manager
@NoArgsConstructor
@AllArgsConstructor
@Data //Lombok diminue a verbosidade das classes, evitando get, set, toString, hashcode e equals
@Table(name = "tab_time") //Como o nome da tabela no banco é diferente colocamos esta anotação com o nome correto
public class Time {

    @Id //Chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Chave vai ser gerada automaticamente
    private Integer id;

    @Column(name = "nome", length = 100, nullable = false) //Se quisermos um nome diferente podemos explicitar além de outras configurações
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_cidade", referencedColumnName = "id", nullable = false) //Define como será feita a junção para captura de dados
    private Cidade cidade;

    @ManyToOne
    @JoinColumn(name = "id_tecnico", referencedColumnName = "id") //Define como será feita a junção para captura de dados
    private Tecnico tecnico;

    public Time(Integer id) {
        this.id = id;
    }
}
