package br.com.techlead.springboot.rest;

import br.com.techlead.springboot.model.Jogo;
import br.com.techlead.springboot.model.JogoPK;
import br.com.techlead.springboot.model.Time;
import br.com.techlead.springboot.service.IJogoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("jogos")
@Api(value = "Jogo", description = "Jogo Descrição")
public class JogoRest {
    @Autowired
    private IJogoService jogoService;

    @GetMapping
    @ApiOperation(value = "Busca todos os jogadores")
    private Collection<Jogo> buscarTodos() {
        return jogoService.buscarTodos();
    }

    @GetMapping("/{idTimeCasa}/{idTimeVisitante}/")
    @ApiOperation(value = "Busca jogadores por ID")
    private Jogo buscarPorId(@PathVariable("idTimeCasa") Integer idTimeCasa,
                             @PathVariable("idTimeVisitante") Integer idTimeVisitante) {
        JogoPK id = new JogoPK(idTimeCasa, idTimeVisitante);
        return jogoService.buscarPorId(id);
    }

    @PostMapping
    @ApiOperation(value = "Salva um jogo")
    private Jogo salvar(@RequestBody Jogo jogo) {
        return jogoService.salvar(jogo);
    }

    @PutMapping("/{idTimeCasa}/{idTimeVisitante}/")
    @ApiOperation(value = "Edita um jogo")
    private ResponseEntity<Jogo> editar(@RequestBody Jogo jogo, @PathVariable("idTimeCasa") Integer idTimeCasa,
                                        @PathVariable("idTimeVisitante") Integer idTimeVisitante) {
        JogoPK id = new JogoPK(idTimeCasa, idTimeVisitante);
        jogo.setId(id);
        jogo = jogoService.editar(jogo);

        if (jogo == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(jogo);
    }

    @DeleteMapping("/{idTimeCasa}/{idTimeVisitante}/")
    @ApiOperation(value = "Deleta um jogo")
    private ResponseEntity<Jogo> excluir(@PathVariable("idTimeCasa") Integer idTimeCasa,
                                         @PathVariable("idTimeVisitante") Integer idTimeVisitante) {
        JogoPK id = new JogoPK(idTimeCasa, idTimeVisitante);
        if (jogoService.excluir(id) == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build(); // Retorna sem conteúdo com código 204
    }
}
