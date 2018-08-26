package br.com.techlead.springboot.rest;

import br.com.techlead.springboot.model.Perfil;
import br.com.techlead.springboot.service.IPerfilService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("perfils") // Nome do resource
@Api(value = "Perfil", description = "Perfil Descrição") // Swagger
public class PerfilRest {

    @Autowired
    IPerfilService perfilService;

    @GetMapping //Método GET
    @ApiOperation(value = "Busca todos os perfils")
    public Collection<Perfil> buscarTodos() {
        return perfilService.buscarTodos();
    }

    @GetMapping("/{id}") //Método GET com parametro
    @ApiOperation(value = "Busca um perfil por ID")
    //Response Entity para caso não seja encontrado seja amostrado uma mensagem do tipo 404
    public ResponseEntity<Perfil> buscarUm(@PathVariable("id") Integer id) {
        Perfil perfil = perfilService.buscarPorId(id);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(perfil);
    }

    @PostMapping // Método POST com objeto json
    @ApiOperation(value = "Salva um perfil")
    public Perfil salvar(@Valid @RequestBody Perfil perfil) {
        return perfilService.salvar(perfil);
    }

    @PutMapping("/{id}") // Método PUT com objeto json e id
    @ApiOperation(value = "Edita um perfil")
    public ResponseEntity<Perfil> atualizar(@PathVariable("id") Integer id, @Valid @RequestBody Perfil perfil) {
        perfil.setId(id);
        perfil = perfilService.editar(perfil);

        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(perfil);
    }

    @DeleteMapping("/{id}") // Método DELETE por id
    @ApiOperation(value = "Deleta um perfil")
    public ResponseEntity<Void> excluir(@PathVariable("id") Integer id) {
        if (perfilService.excluir(id) == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build(); // Retorna sem conteúdo com código 204

    }
}
