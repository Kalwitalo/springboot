package br.com.techlead.springboot.service;

import br.com.techlead.springboot.model.Jogo;
import br.com.techlead.springboot.model.JogoPK;
import br.com.techlead.springboot.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class JogoService implements IJogoService {
    @Autowired
    private JogoRepository jogoRepository;


    @Override
    public Collection<Jogo> buscarTodos() {
        return jogoRepository.findAll();
    }

    @Override
    public Jogo buscarPorId(JogoPK id) {
        return jogoRepository.findById(id).orElse(null);
    }

    @Override
    public Jogo salvar(Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    @Override
    public Jogo editar(Jogo jogo) {
        Jogo jogoBanco = buscarPorId(jogo.getId());
        if (jogoBanco != null) {
            return jogoRepository.save(jogo);
        }
        return null;
    }

    @Override
    public JogoPK excluir(JogoPK id) {
        Jogo jogoBanco = buscarPorId(id);
        if (jogoBanco != null) {
            jogoRepository.delete(jogoBanco);
            return jogoBanco.getId();
        }
        return null;
    }
}
