package br.com.techlead.springboot.service;

import br.com.techlead.springboot.model.Cidade;

import java.util.Collection;

public interface ICidadeService {
    Collection<Cidade> buscarTodos();
    Cidade buscarPorId(Integer id);
    Cidade salvar(Cidade cidade);
    Cidade editar(Cidade cidade);
    Integer excluir(Integer id);

}
