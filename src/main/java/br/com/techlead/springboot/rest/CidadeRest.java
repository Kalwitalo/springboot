package br.com.techlead.springboot.rest;

import br.com.techlead.springboot.model.Cidade;
import br.com.techlead.springboot.service.ICidadeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("cidades") // Nome do resource
@Api(value = "Cidade", description = "Operações de Cidade") // Swagger
public class CidadeRest {

    @Autowired
    ICidadeService cidadeService;

    @GetMapping //Método GET
    @ApiOperation(value = "Busca todos as cidades")
    public Collection<Cidade> buscarTodos() {
        return cidadeService.buscarTodos();
    }

    @GetMapping("/{id}") //Método GET com parametro
    @ApiOperation(value = "Busca um perfil por ID")
    //Response Entity para caso não seja encontrado seja amostrado uma mensagem do tipo 404
    public ResponseEntity<Cidade> buscarUm(@PathVariable("id") Integer id) {
        Cidade cidade = cidadeService.buscarPorId(id);
        if (cidade == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cidade);
    }

    @PostMapping // Método POST com objeto json
    @ApiOperation(value = "Salva um cidade")
    public Cidade salvar(@Valid @RequestBody Cidade cidade) {
        return cidadeService.salvar(cidade);
    }

    @PutMapping("/{id}") // Método PUT com objeto json e id
    @ApiOperation(value = "Edita um cidade")
    public ResponseEntity<Cidade> atualizar(@PathVariable("id") Integer id, @Valid @RequestBody Cidade cidade) {
        cidade.setId(id);
        cidade = cidadeService.editar(cidade);

        if (cidade == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cidade);
    }

    @DeleteMapping("/{id}") // Método DELETE por id
    @ApiOperation(value = "Deleta um perfil")
    public ResponseEntity<Void> excluir(@PathVariable("id") Integer id) {
        if (cidadeService.excluir(id) == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build(); // Retorna sem conteúdo com código 204

    }
}
