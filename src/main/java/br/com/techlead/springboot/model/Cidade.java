package br.com.techlead.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity //Anotação abstrai e faz a classe ser gerenciada pelo entity manager
@Data //Lombok diminue a verbosidade das classes, evitando get, set, toString, hashcode e equals
@NoArgsConstructor //Cria um construtor sem nenhum parâmetro
@AllArgsConstructor // Cria um construtor com todos os parâmetros
@Table(name = "tab_cidade") //Como o nome da tabela no banco é diferente colocamos esta anotação com o nome correto
public class Cidade {

    @Id //Chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Chave vai ser gerada automaticamente
    private Integer id;

    @Column(name = "nome", length = 100, nullable = false) //Se quisermos um nome diferente podemos explicitar além de outras configurações
    private String nome;
}
