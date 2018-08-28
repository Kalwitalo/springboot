package br.com.techlead.springboot.repository;

import br.com.techlead.springboot.model.Jogador;
import br.com.techlead.springboot.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Integer> {
    Collection<Jogador> findByTime(@Param("time") Time time);
}
