package br.com.iga.cadastro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.iga.cadastro.domain.Aluno;
import br.com.iga.cadastro.repository.AlunoRepository;
import br.com.iga.cadastro.service.exception.DataIntegrityException;
import br.com.iga.cadastro.service.exception.ObjectNotFoundException;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	public List<Aluno> findAll(){
		return alunoRepository.findAll();
	}
	
	public Optional<Aluno> findOne(Long id) {
		Optional<Aluno> aluno = alunoRepository.findById(id);
		if(aluno == null) {
			throw new ObjectNotFoundException("Aluno não encontrado!: Id: " + id
					+ ", Tipo: " + Aluno.class.getName());
		}
		return aluno;
	}
	
	public Aluno save(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public void delete(Long id) {
		findOne(id);
		try {
			alunoRepository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um aluno que possui curso");
		}
	}
	
	public Aluno update(Aluno aluno) {
		findOne(aluno.getId());
		return alunoRepository.save(aluno);
	}
}
