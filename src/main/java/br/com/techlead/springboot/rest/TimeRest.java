package br.com.techlead.springboot.rest;

import br.com.techlead.springboot.model.Jogador;
import br.com.techlead.springboot.model.Time;
import br.com.techlead.springboot.service.ITimeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("times") // Nome do resource
@Api(value = "Time", description = "Operações de Time") // Swagger
public class TimeRest {

    @Autowired
    ITimeService timeService;

    @GetMapping //Método GET
    @ApiOperation(value = "Busca todos os times")
    public Collection<Time> buscarTodos() {
        return timeService.buscarTodos();
    }

    @GetMapping("/{id}/") //Método GET com parametro
    @ApiOperation(value = "Busca um time por ID")
    //Response Entity para caso não seja encontrado seja amostrado uma mensagem do tipo 404
    public ResponseEntity<Time> buscarUm(@PathVariable("id") Integer id) {
        Time time = timeService.buscarPorId(id);
        if (time == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(time);
    }

    @PostMapping // Método POST com objeto json
    @ApiOperation(value = "Salva um time")
    public Time salvar(@Valid @RequestBody Time time) {
        return timeService.salvar(time);
    }

    @PutMapping("/{id}") // Método PUT com objeto json e id
    @ApiOperation(value = "Edita um time")
    public ResponseEntity<Time> atualizar(@PathVariable("id") Integer id, @Valid @RequestBody Time time) {
        time.setId(id);
        time = timeService.editar(time);

        if (time == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(time);
    }

    @DeleteMapping("/{id}") // Método DELETE por id
    @ApiOperation(value = "Deleta um time")
    public ResponseEntity<Void> excluir(@PathVariable("id") Integer id) {
        if (timeService.excluir(id) == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build(); // Retorna sem conteúdo com código 204

    }
}
