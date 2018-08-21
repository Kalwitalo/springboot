package br.com.techlead.springboot.rest;

import br.com.techlead.springboot.model.Perfil;
import br.com.techlead.springboot.service.IPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("perfils")
public class PerfilRest {

    @Autowired
    IPerfilService perfilService;

    @GetMapping //Método GET
    public Collection<Perfil> buscarTodos() {
        return perfilService.buscarTodos();
    }

    @GetMapping("/{id}") //Método GET com parametro
    //Response Entity para caso não seja encontrado seja amostrado uma mensagem do tipo 404
    public ResponseEntity<Perfil> buscarUm(@PathVariable("id") Integer id) {
        Perfil perfil = perfilService.buscarPorId(id);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(perfil);
    }

    @PostMapping // Método POST com objeto json
    public Perfil salvar(@Valid @RequestBody Perfil perfil) {
        return perfilService.salvar(perfil);
    }

    @PutMapping("/{id}") // Método PUT com objeto json e id
    public ResponseEntity<Perfil> atualizar(@PathVariable("id") Integer id, @Valid @RequestBody Perfil perfil) {
        perfil.setId(id);
        perfil = perfilService.editar(perfil);

        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(perfil);
    }

    @DeleteMapping("/{id}") // Método DELETE por id
    public ResponseEntity<Void> excluir(@PathVariable("id") Integer id) {
        if (perfilService.excluir(id) == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build(); // Retorna sem conteúdo com código 204

    }
}
