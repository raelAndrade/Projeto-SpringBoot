package br.com.iga.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.iga.cadastro.domain.Curso;

/**
 * RESPONSÁVEIS PELO ACESSO A DADOS
 * 
 * REPOSITÓRIOS TEM COMO FINALIDADE FACILITAR AS OPERAÇÕES ENTRE TABELAS DE BANCOS DE DADOS E OBJETOS JAVA
 * 
 * @author Israel
 */
@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
