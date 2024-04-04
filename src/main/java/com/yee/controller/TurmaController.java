package com.yee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yee.entities.Aluno;
import com.yee.entities.Turma;
import com.yee.services.TurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaController {
    private final TurmaService turmaService;

    @Autowired
    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> buscaTurmaControlId(@PathVariable long id) {
        Turma turma = turmaService.buscaTurmaPeloId(id);
        if (turma != null) {
            return ResponseEntity.ok(turma);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Turma>> buscaTodasTurmasControl() {
        List<Turma> turmas = turmaService.buscaTodosTurmas();
        return ResponseEntity.ok(turmas);
    }
    @GetMapping("/descricao/{descricao}")
    public ResponseEntity<List<Turma>> buscarTurmasPorDescricao(@PathVariable String descricao){
    	List<Turma> turmas = turmaService.buscarTurmasPorDescricao(descricao);
    	return ResponseEntity.ok(turmas);
    }
    

    @PostMapping
    public ResponseEntity<Turma> salvaTurmaControl(@RequestBody Turma turma) {
        Turma salvaTurma = turmaService.salvaTurma(turma);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvaTurma);
    }
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Turma>> buscarTurmasPorNome(@PathVariable String nome){
    	List<Turma> turmas = turmaService.buscarTurmasPorDescricao(nome);
    	return ResponseEntity.ok(turmas);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Turma> alteraTurmaControl(@PathVariable Long id, @RequestBody Turma turma) {
        Turma alteraTurma = turmaService.alterarTurma(id, turma);
        if (alteraTurma != null) {
            return ResponseEntity.ok(turma);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> apagaTurmaControl(@PathVariable Long id) {
        boolean apagar = turmaService.apagarTurma(id);
        if (apagar) {
            return ResponseEntity.ok().body("A Turma foi excluída com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}