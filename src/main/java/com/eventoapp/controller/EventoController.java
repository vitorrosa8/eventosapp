package com.eventoapp.controller;

import javax.validation.Valid;

import com.eventoapp.models.Convidado;
import com.eventoapp.models.Evento;
import com.eventoapp.repository.ConvidadoRepository;
import com.eventoapp.repository.EventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Class EventoController
 */
@Controller
public class EventoController {

	/**
	 * Autowired
	 */
	@Autowired
	private EventoRepository er;
	/**
	 * Autowired
	 */
	@Autowired
	private ConvidadoRepository cr;

	/**
	 * Method form GET
	 */
	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
	public String formGET() {
		return "evento/formEvento";
	}

	/**
	 * Method form POST
	 */
	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
	public String form(@Valid Evento evento, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastrarEvento";
		}

		er.save(evento);
		attributes.addFlashAttribute("mensagem", "Evento cadastrado com sucesso!");
		return "redirect:/cadastrarEvento";
	}

	/**
	 * Method listaEventos
	 */
	@RequestMapping("/eventos")
	public ModelAndView listaEventos() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Evento> eventos = er.findAll();
		mv.addObject("eventos", eventos);
		return mv;
	}

	/**
	 * Method detalhesEvento GET
	 */
	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
	public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo) {
		Evento evento = er.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("evento/detalhesEvento");
		mv.addObject("evento", evento);

		Iterable<Convidado> convidados = cr.findByEvento(evento);
		mv.addObject("convidados", convidados);

		return mv;
	}

	/**
	 * Method detalhesEvento POST
	 */
	@RequestMapping(value = "/{codigo}", method = RequestMethod.POST)
	public String detalhesEventoPost(@PathVariable("codigo") long codigo, @Valid Convidado convidado,
			BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/{codigo}";
		}
		Evento evento = er.findByCodigo(codigo);
		convidado.setEvento(evento);
		cr.save(convidado);
		attributes.addFlashAttribute("mensagem", "Convidado adicionado com sucesso!");
		return "redirect:/{codigo}";
	}

	/**
	 * Method deletarEvento
	 */
	@RequestMapping("/deletarEvento")
	public String deletarEvento(long codigo, RedirectAttributes attributes) {
		Evento evento = er.findByCodigo(codigo);
		er.delete(evento);
		attributes.addFlashAttribute("sucesso", "Evento deletado com sucesso!");
		return "redirect:/eventos";
	}

	/**
	 * Method deletarConvidado
	 */
	@RequestMapping("/deletarConvidado")
	public String deletarConvidado(String cpf, RedirectAttributes attributes) {
		Convidado convidado = cr.findByCpf(cpf);
		cr.delete(convidado);
	
		Evento evento = convidado.getEvento();
		long codigoLong = evento.getCodigo();
		String codigo = "" + codigoLong;
		attributes.addFlashAttribute("sucesso", "Convidado deletado com sucesso!");
		return "redirect:/" + codigo;
	}

}
