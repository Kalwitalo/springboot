package br.com.techlead.springboot.rest;

import br.com.techlead.springboot.model.Jogador;
import br.com.techlead.springboot.model.Time;
import br.com.techlead.springboot.service.IJogadorService;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("jogadores")
@Api(value = "Jogador", description = "Operações de jogador")
public class JogadorRest {
    @Autowired
    private IJogadorService jogadorService;

    @GetMapping
    @ApiOperation(value = "Busca todos os jogadores")
    private Collection<Jogador> buscarTodos(){
        return jogadorService.buscarTodos();
    }

    @GetMapping("/time/{idTime}") //Método GET
    @ApiOperation(value = "Busca todos os jogadores do time passado por ID")
    public Collection<Jogador> buscarTodosJogadoresPorTime(@PathVariable(value = "idTime") Integer id) {
        return jogadorService.buscarTodosJogadores(new Time(id));
    }

    @GetMapping("/{id}/")
    @ApiOperation(value = "Busca um jogador por ID")
    private ResponseEntity<Jogador> buscarUm(@PathVariable("id") Integer id) {
        Jogador jogador = jogadorService.buscarPorId(id);
        if (jogador == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(jogador);
    }

    @PostMapping
    @ApiOperation(value = "Salva um jogador")
    private Jogador salvar(@Valid @RequestBody Jogador jogador) {

        return jogadorService.salvar(jogador);
    }

    @PutMapping("/{id}/")
    @ApiOperation(value = "Edita um jogador")
    private ResponseEntity<Jogador> editar(@Valid @RequestBody Jogador jogador, @PathVariable("id") Integer id) {
        jogador.setId(id);
        jogador = jogadorService.editar(jogador);
        if (jogador == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(jogador);
    }

    @DeleteMapping("/{id}/")
    @ApiOperation(value = "Dela um jogador")
    private ResponseEntity<Void> excluir(@PathVariable("id") Integer id) {
        if (jogadorService.excluir(id) == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
