package br.com.techlead.springboot.service;

import br.com.techlead.springboot.model.Jogador;
import br.com.techlead.springboot.model.Time;

import java.util.Collection;

public interface ITimeService {
    Collection<Time> buscarTodos();
    Time buscarPorId(Integer id);
    Time salvar(Time time);
    Time editar(Time time);
    Integer excluir(Integer id);

}
