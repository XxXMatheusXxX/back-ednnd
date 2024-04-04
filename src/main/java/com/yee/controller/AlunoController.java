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
import com.yee.services.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    private final AlunoService alunoService;

    @Autowired
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscaAlunoControlId(@PathVariable long id) {
        Aluno aluno = alunoService.buscaAlunoPeloId(id);
        if (aluno != null) {
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> buscaTodasAlunosControl() {
        List<Aluno> alunos = alunoService.buscaTodosAlunos();
        return ResponseEntity.ok(alunos);
    }
    @GetMapping("/cidade/{cidade}")
    public ResponseEntity<List<Aluno>> buscarAlunosPorCidade(@PathVariable String cidade){
    	List<Aluno> alunos = alunoService.buscarAlunosPorCidade(cidade);
    	return ResponseEntity.ok(alunos);
    }
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Aluno>> buscarAlunosPorNome(@PathVariable String nome){
    	List<Aluno> alunos = alunoService.buscarAlunosPorCidade(nome);
    	return ResponseEntity.ok(alunos);
    }
    @GetMapping("/renda/{renda}")
    public ResponseEntity<List<Aluno>> buscarAlunosPorRenda(@PathVariable String renda){
    	List<Aluno> alunos = alunoService.buscarAlunosPorCidade(renda);
    	return ResponseEntity.ok(alunos);
    }
    @GetMapping("/ra/{ra}")
    public ResponseEntity<List<Aluno>> buscarAlunosPorRa(@PathVariable String ra){
    	List<Aluno> alunos = alunoService.buscarAlunosPorCidade(ra);
    	return ResponseEntity.ok(alunos);
    }
   
    @PostMapping
    public ResponseEntity<Aluno> salvaAlunoControl(@RequestBody Aluno aluno) {
        Aluno salvaAluno = alunoService.salvaAluno(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvaAluno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> alteraAlunoControl(@PathVariable Long id, @RequestBody Aluno aluno) {
        Aluno alteraAluno = alunoService.alterarAluno(id, aluno);
        if (alteraAluno != null) {
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> apagaAlunoControl(@PathVariable Long id) {
        boolean apagar = alunoService.apagarAluno(id);
        if (apagar) {
            return ResponseEntity.ok().body("A Aluno foi excluída com sucesso");
        } else {
            return ResponseEntity.notFound().build();
            
        }
        
    }
}