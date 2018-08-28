package br.com.techlead.springboot.service;

import br.com.techlead.springboot.model.Jogador;
import br.com.techlead.springboot.model.Time;
import br.com.techlead.springboot.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class JogadorService implements IJogadorService {
    @Autowired
    private JogadorRepository jogadorRepository;

    @Override
    @Transactional(readOnly = true)
    public Collection<Jogador> buscarTodos() {
        return jogadorRepository.findAll();
    }

    @Override
    public Collection<Jogador> buscarTodosJogadores(Time time) {
        return jogadorRepository.findByTime(time);
    }

    @Override
    @Transactional(readOnly = true) //Atribui como transacional para caso de algum problema ele faça o rollback
    public Jogador buscarPorId(Integer id) {
        return jogadorRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Jogador salvar(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    @Override
    @Transactional
    public Jogador editar(Jogador jogador) {
        Jogador jogadorBanco = buscarPorId(jogador.getId());
        if (jogadorBanco != null) {
            return jogadorRepository.save(jogador);
        }
        return null;
    }

    @Override
    @Transactional
    public Integer excluir(Integer id) {
        Jogador jogadorBanco = buscarPorId(id);
        if (jogadorBanco != null) {
            jogadorRepository.delete(jogadorBanco);
            return jogadorBanco.getId();
        }
        return null;
    }
}
