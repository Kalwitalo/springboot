package br.com.techlead.springboot.enumeration;

public enum PosicaoEnum {

    ATACANTE("Atacante"),
    MEIA("Meia"),
    LATERAL("Lateral"),
    ZAGUEIRO("Zagueiro");

    private String nome;

    private PosicaoEnum(String nome){
        this.nome = nome;
    }

    private String getNome() {
        return nome;
    }
}
