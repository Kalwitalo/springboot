package br.com.techlead.springboot.model;

import br.com.techlead.springboot.enumeration.PosicaoEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tab_jogador")
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", length = 100, nullable = false)
    @Size(min = 10, message = "Campo nome precisa ter no mínimo 10 caracteres")
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "posicao", length = 50, nullable = false)
    private PosicaoEnum posicao;

    @ManyToOne
    @JoinColumn(name = "id_time", referencedColumnName = "id", nullable = false)
    private Time time;
}
