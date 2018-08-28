package br.com.techlead.springboot.repository;

import br.com.techlead.springboot.model.Tecnico;
import br.com.techlead.springboot.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends JpaRepository<Time, Integer> {

}
