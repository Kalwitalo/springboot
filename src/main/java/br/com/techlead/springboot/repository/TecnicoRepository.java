package br.com.techlead.springboot.repository;

import br.com.techlead.springboot.model.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
