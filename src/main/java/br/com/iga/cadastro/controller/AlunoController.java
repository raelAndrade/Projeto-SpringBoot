package br.com.iga.cadastro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.iga.cadastro.domain.Aluno;
import br.com.iga.cadastro.service.AlunoService;

@Controller
public class AlunoController {

	@Autowired
	private AlunoService service;
	
	@GetMapping("/")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("/alunoList");
		mv.addObject("alunos", service.findAll());
		return mv;
	}
	
	@GetMapping("/add")
	public ModelAndView add(Aluno aluno) {
		ModelAndView mv = new ModelAndView("/alunoAdd");
		mv.addObject("aluno", aluno);
		return mv;
	}
	
	@PostMapping
	public ModelAndView save(@Validated Aluno aluno, BindingResult result) {
		if(result.hasErrors()) {
			return add(aluno);
		}
		service.save(aluno);
		return findAll();
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id, Aluno aluno) {
		service.findOne(id);
		return add(aluno);
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		service.delete(id);
		return findAll();
	}
}
