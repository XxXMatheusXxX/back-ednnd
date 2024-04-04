package com.yee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yee.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	List<Aluno> findByCidade(String cidade);
	List<Aluno> findByRenda(String renda);
	List<Aluno> findByRa(String ra);
	List<Aluno> findByNome(String nome);
	
}
