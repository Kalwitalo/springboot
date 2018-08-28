package br.com.techlead.springboot.service;

import br.com.techlead.springboot.model.Tecnico;

import java.util.Collection;

public interface ITecnicoService {
    Collection<Tecnico> buscarTodos();
    Tecnico buscarPorId(Integer id);
    Tecnico salvar(Tecnico tecnico);
    Tecnico editar(Tecnico tecnico);
    Integer excluir(Integer id);

}
