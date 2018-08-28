package br.com.techlead.springboot.service;

import br.com.techlead.springboot.model.Tecnico;
import br.com.techlead.springboot.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class TecnicoService implements ITecnicoService {

    @Autowired
    private TecnicoRepository perfilRepository;

    @Transactional(readOnly = true) //Atribui como transacional para caso de algum problema ele faça o rollback
    public Collection<Tecnico> buscarTodos() {
        return perfilRepository.findAll();
    }

    @Transactional(readOnly = true) //Atribui como transacional para caso de algum problema ele faça o rollback
    public Tecnico buscarPorId(Integer id) {
        return perfilRepository.findById(id).orElse(null);
    }

    @Transactional //Atribui como transacional para caso de algum problema ele faça o rollback
    public Tecnico salvar(Tecnico tecnico) {
        return perfilRepository.save(tecnico);
    }

    @Transactional //Atribui como transacional para caso de algum problema ele faça o rollback
    public Tecnico editar(Tecnico tecnico) {
        Tecnico tecnicoBase = buscarPorId(tecnico.getId());
        if (tecnicoBase != null) {
            perfilRepository.save(tecnico);
            return tecnico;
        }
        return null;

    }

    @Transactional //Atribui como transacional para caso de algum problema ele faça o rollback
    public Integer excluir(Integer id) {
        Tecnico tecnico = buscarPorId(id);
        if (tecnico != null) {
            perfilRepository.delete(tecnico);
            return id;
        }
        return null;
    }
}
