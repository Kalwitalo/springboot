package br.com.techlead.springboot.service;

import br.com.techlead.springboot.model.Cidade;
import br.com.techlead.springboot.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class CidadeService implements ICidadeService {

    @Autowired
    private CidadeRepository perfilRepository;

    @Transactional(readOnly = true) //Atribui como transacional para caso de algum problema ele faça o rollback
    public Collection<Cidade> buscarTodos() {
        return perfilRepository.findAll();
    }

    @Transactional(readOnly = true) //Atribui como transacional para caso de algum problema ele faça o rollback
    public Cidade buscarPorId(Integer id) {
        return perfilRepository.findById(id).orElse(null);
    }

    @Transactional //Atribui como transacional para caso de algum problema ele faça o rollback
    public Cidade salvar(Cidade cidade) {
        return perfilRepository.save(cidade);
    }

    @Transactional //Atribui como transacional para caso de algum problema ele faça o rollback
    public Cidade editar(Cidade cidade) {
        Collection<Cidade> cidades = buscarTodos();
        for (Cidade p : cidades) {
            if (p.getId().equals(cidade.getId())) {
                return perfilRepository.save(cidade);
            }
        }
        return null;
    }

    @Transactional //Atribui como transacional para caso de algum problema ele faça o rollback
    public Integer excluir(Integer id) {
        Cidade cidade = buscarPorId(id);
        if (cidade != null) {
            perfilRepository.delete(cidade);
            return id;
        }
        return null;
    }
}
