package br.com.techlead.springboot.repository;

import br.com.techlead.springboot.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.Collection;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer> {
    @Query("select p from Perfil p where p.nome = :nome")
    Collection<Perfil> buscarNome(@PathParam("nome") String nome);
}
