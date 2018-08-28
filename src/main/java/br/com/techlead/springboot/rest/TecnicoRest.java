package br.com.techlead.springboot.rest;

import br.com.techlead.springboot.model.Tecnico;
import br.com.techlead.springboot.service.ITecnicoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("tecnicos") // Nome do resource
@Api(value = "Tecnico", description = "Operações de Tecnico") // Swagger
public class TecnicoRest {

    @Autowired
    ITecnicoService tecnicoService;

    @GetMapping //Método GET
    @ApiOperation(value = "Busca todos os tecnicos")
    public Collection<Tecnico> buscarTodos() {
        return tecnicoService.buscarTodos();
    }

    @GetMapping("/{id}") //Método GET com parametro
    @ApiOperation(value = "Busca um perfil por ID")
    //Response Entity para caso não seja encontrado seja amostrado uma mensagem do tipo 404
    public ResponseEntity<Tecnico> buscarUm(@PathVariable("id") Integer id) {
        Tecnico tecnico = tecnicoService.buscarPorId(id);
        if (tecnico == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(tecnico);
    }

    @PostMapping // Método POST com objeto json
    @ApiOperation(value = "Salva um tecnico")
    public Tecnico salvar(@Valid @RequestBody Tecnico tecnico) {
        return tecnicoService.salvar(tecnico);
    }

    @PutMapping("/{id}") // Método PUT com objeto json e id
    @ApiOperation(value = "Edita um tecnico")
    public ResponseEntity<Tecnico> atualizar(@PathVariable("id") Integer id, @Valid @RequestBody Tecnico tecnico) {
        tecnico.setId(id);
        tecnico = tecnicoService.editar(tecnico);

        if (tecnico == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(tecnico);
    }

    @DeleteMapping("/{id}") // Método DELETE por id
    @ApiOperation(value = "Deleta um perfil")
    public ResponseEntity<Void> excluir(@PathVariable("id") Integer id) {
        if (tecnicoService.excluir(id) == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build(); // Retorna sem conteúdo com código 204

    }
}
