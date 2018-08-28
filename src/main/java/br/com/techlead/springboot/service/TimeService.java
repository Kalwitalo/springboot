package br.com.techlead.springboot.service;

import br.com.techlead.springboot.model.Jogador;
import br.com.techlead.springboot.model.Time;
import br.com.techlead.springboot.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class TimeService implements ITimeService {

    @Autowired
    private TimeRepository timeRepository;

    @Transactional(readOnly = true) //Atribui como transacional para caso de algum problema ele faça o rollback
    public Collection<Time> buscarTodos() {
        return timeRepository.findAll();
    }

    @Transactional(readOnly = true) //Atribui como transacional para caso de algum problema ele faça o rollback
    public Time buscarPorId(Integer id) {
        return timeRepository.findById(id).orElse(null);
    }

    @Transactional //Atribui como transacional para caso de algum problema ele faça o rollback
    public Time salvar(Time time) {
        return timeRepository.save(time);
    }

    @Transactional //Atribui como transacional para caso de algum problema ele faça o rollback
    public Time editar(Time time) {
        Time timeBase = buscarPorId(time.getId());
        if (timeBase != null) {
            timeRepository.save(time);
            return time;
        }
        return null;

    }

    @Transactional //Atribui como transacional para caso de algum problema ele faça o rollback
    public Integer excluir(Integer id) {
        Time time = buscarPorId(id);
        if (time != null) {
            timeRepository.delete(time);
            return id;
        }
        return null;
    }
}
