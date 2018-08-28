package br.com.techlead.springboot.repository;

import br.com.techlead.springboot.model.Jogo;
import br.com.techlead.springboot.model.JogoPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, JogoPK> {
}
