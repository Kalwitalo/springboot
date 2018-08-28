package br.com.techlead.springboot.service;

import br.com.techlead.springboot.model.Jogo;
import br.com.techlead.springboot.model.JogoPK;

import java.util.Collection;

public interface IJogoService {
    Collection<Jogo> buscarTodos();
    Jogo buscarPorId(JogoPK id);
    Jogo salvar(Jogo jogo);
    Jogo editar(Jogo jogo);
    JogoPK excluir(JogoPK id);
}
