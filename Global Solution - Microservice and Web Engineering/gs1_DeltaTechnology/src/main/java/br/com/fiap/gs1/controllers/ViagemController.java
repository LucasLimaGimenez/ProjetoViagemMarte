package br.com.fiap.gs1.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.gs1.dtos.ViagemDTO;
import br.com.fiap.gs1.models.Viagem;
import br.com.fiap.gs1.repositories.ViagemRepository;


@Controller
public class ViagemController {
	
	@Autowired
	private ViagemRepository viagemRepository;
	
	@GetMapping("**/index")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("viagem/index");	
	
		return model;
	}
	
	@GetMapping("**/cadastrarViagem")
	public ModelAndView cadastrar() {
		
		ModelAndView model = new ModelAndView("cadastro/cadastrarViagem");	
		model.addObject("viagemobj",new Viagem());
		
		return model;
	}
	
	@PostMapping("**/salvarViagem")
	public ModelAndView salvar(@Valid Viagem viagem, BindingResult result) {
		
		ModelAndView model = new ModelAndView("cadastro/cadastrarViagem");
		
		if(!viagem.validaMultiplo3() || result.hasErrors()) {
			System.out.println("Favor inserir os dados de forma correta");
			model.setViewName("redirect:/index");
			return model;
		}
		
		Iterable<Viagem> viagemIt = viagemRepository.findAll();
		model.addObject("listaviagem",viagemIt);
		model.addObject("viagemobj", new Viagem());
		viagem.calculaDias();
		viagemRepository.save(viagem);
		
		return model;
	}
	
	@GetMapping("**/listarViagem")
	public ModelAndView listar() {
		ModelAndView model = new ModelAndView("lista/listarViagem");	
		Iterable<Viagem> viagemIt = viagemRepository.findAll();
		model.addObject("listaviagem",viagemIt);
		model.addObject("viagemobj", new Viagem());
		
		return model;
	}
	
	@GetMapping("**/alterarViagem/{idviagem}")
	public ModelAndView alterar(@PathVariable("idviagem") Long idviagem) {
		
		Optional<Viagem> viagem = viagemRepository.findById(idviagem);
		
		ModelAndView model = new ModelAndView("altera/alterarViagem");	
		model.addObject("viagemobj",viagem.get());
		
		return model;
	}
	
	@GetMapping("**/excluirViagem/{idviagem}")
	public ModelAndView excluir(@PathVariable("idviagem") Long idviagem) {
		
		viagemRepository.deleteById(idviagem);
		
		ModelAndView model = new ModelAndView("exclui/excluirViagem");	
		model.addObject("listaviagem",viagemRepository.findAll());
		model.addObject("viagemobj",new Viagem());
		
		return model;
	}

}
