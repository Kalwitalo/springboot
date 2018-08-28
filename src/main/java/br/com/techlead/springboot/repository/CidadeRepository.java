package br.com.techlead.springboot.repository;

import br.com.techlead.springboot.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.Collection;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

    Collection<Cidade> findByNome(String nome);

    @Query("select p from Cidade p where p.nome = :nome")
    Collection<Cidade> buscarNome(@PathParam("nome") String nome);
}
