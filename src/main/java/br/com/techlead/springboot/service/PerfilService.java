package br.com.techlead.springboot.service;

import br.com.techlead.springboot.model.Perfil;
import br.com.techlead.springboot.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class PerfilService implements IPerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    @Transactional(readOnly = true) //Atribui como transacional para caso de algum problema ele faça o rollback
    public Collection<Perfil> buscarTodos() {
        return perfilRepository.findAll();
    }

    @Transactional(readOnly = true) //Atribui como transacional para caso de algum problema ele faça o rollback
    public Perfil buscarPorId(Integer id) {
        return perfilRepository.findById(id).orElse(null);
    }

    @Transactional //Atribui como transacional para caso de algum problema ele faça o rollback
    public Perfil salvar(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    @Transactional //Atribui como transacional para caso de algum problema ele faça o rollback
    public Perfil editar(Perfil perfil) {
        Collection<Perfil> Perfils = buscarTodos();
        for (Perfil p : Perfils) {
            if (p.getId().equals(perfil.getId())) {
                return perfilRepository.save(perfil);
            }
        }
        return null;
    }

    @Transactional //Atribui como transacional para caso de algum problema ele faça o rollback
    public Integer excluir(Integer id) {
        Perfil perfil = buscarPorId(id);
        if (perfil != null) {
            perfilRepository.delete(perfil);
            return id;
        }
        return null;
    }
}
