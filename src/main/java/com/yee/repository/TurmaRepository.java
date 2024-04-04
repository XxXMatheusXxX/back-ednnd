package com.yee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yee.entities.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
	List<Turma> findByDescricao(String descricao);
	List<Turma> findByNome(String nome);
	
}