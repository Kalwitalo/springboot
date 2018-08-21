package br.com.techlead.springboot.service;

import br.com.techlead.springboot.model.Perfil;

import java.util.Collection;

public interface IPerfilService {
    Collection<Perfil> buscarTodos();
    Perfil buscarPorId(Integer id);
    Perfil salvar(Perfil perfil);
    Perfil editar(Perfil perfil);
    Integer excluir(Integer id);

}
