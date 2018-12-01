package br.com.iga.cadastro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.iga.cadastro.domain.Curso;
import br.com.iga.cadastro.repository.CursoRepository;
import br.com.iga.cadastro.service.exception.DataIntegrityException;
import br.com.iga.cadastro.service.exception.ObjectNotFoundException;

@Service
public class CursoService {
	
	/**
	 * CLASSES DE SERVIÇO E/OU NEGÓCIO
	 */

	/* O proposito do @Autowired é injetar uma instância da classe declarada como atributo 
		no escopo da classe trabalhada sem que a segunda saiba como instanciar a primeira, reduzindo o acoplamento
	
		A classe de serviço deve fornecer as opções de recuperação, inserção, edição e exclusão
	*/
	@Autowired 
	private CursoRepository cursoRepository;
	
	public List<Curso> findAll(){
		return cursoRepository.findAll();
	}
	
	public Optional<Curso> findOne(Long id) {
		Optional<Curso> curso = cursoRepository.findById(id);
		if(curso == null) {
			throw new ObjectNotFoundException("Curso não encontrado!: Id: " + id
					+ ", Tipo: " + Curso.class.getName());
		}
		return curso;
	}
	
	public Curso save(Curso curso) {
		return cursoRepository.save(curso);
	}
	
	public void delete(Long id) {
		findOne(id);
		try {
			cursoRepository.deleteById(id);
		}catch(DataIntegrityException e) {
			throw new DataIntegrityException("Não é possível excluir o curso porque possui aluno");
		}
	}
	
	public Curso update(Curso curso) {
		findOne(curso.getId());
		return cursoRepository.save(curso);
	}
}
