package br.com.techlead.springboot.service;

import br.com.techlead.springboot.model.Jogador;
import br.com.techlead.springboot.model.Time;

import java.util.Collection;

public interface IJogadorService {
    Collection<Jogador> buscarTodos();
    Collection<Jogador> buscarTodosJogadores(Time time);
    Jogador buscarPorId(Integer id);
    Jogador salvar(Jogador jogador);
    Jogador editar(Jogador jogador);
    Integer excluir(Integer id);
}
