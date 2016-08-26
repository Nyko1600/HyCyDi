package com.sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.sistema.pojo.HistoriaClinica;
import com.sistema.pojo.Usuario;
import com.sistema.service.ConsultaService;
import com.sistema.service.DiagnosticoService;
import com.sistema.service.FichaService;

import com.sistema.service.HistoriaService;
import com.sistema.service.UsuarioService;

@Controller
@RequestMapping(value="/historia")
public class HistoriaController {

	
	@Autowired
	public UsuarioService usuarioService;
	
	@Autowired
	public HistoriaService historiaService;
	
	@Autowired
	public FichaService fichaService;
	
	@Autowired
	public ConsultaService consultaService;
	
	@Autowired
	public DiagnosticoService diagnosticoService;


	
	@RequestMapping(value="/historiaClinica",method=RequestMethod.GET)
	public String showPacientes(Model model){
		try {

			//List<Usuario> pacientes = usuarioService.findAllPacientes();
			List<Usuario> pacientes = usuarioService.findPacientesSinHistoria();

			Usuario paciente = new Usuario();
			model.addAttribute("paciente",paciente);
			model.addAttribute("pacientes",pacientes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/jsp/historia/historiaView";
	}
	
	@RequestMapping(value="/historiaList",method=RequestMethod.GET)
	public String showHistorias(Model model){
		try {
			List<Usuario> pacientes = usuarioService.findAllPacientes();
			List<HistoriaClinica> historias = historiaService.findAllHistorias();
			System.out.println(historias);
			model.addAttribute("pacientes",pacientes);
			model.addAttribute("historias",historias);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/jsp/historia/historiaList";
	}
	
	
	@RequestMapping(value="/{id}/save",method=RequestMethod.GET)
	public String showHistoria(Model model, @PathVariable("id") int id_paciente){
		
		try {
			Usuario paciente = usuarioService.findById(id_paciente);
			model.addAttribute("paciente",paciente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/jsp/historia/historiaForm";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String showHistoriaSave(Model model, @ModelAttribute("historiaForm") HistoriaClinica historia,
			@RequestParam("id_paciente") int id_pac,
			@RequestParam("nro_historia") int nro_historia){
		
		
			try {
				HistoriaClinica hist = new HistoriaClinica();
				hist.setUsuario(usuarioService.findById(id_pac));
				hist.setNro_historia(nro_historia);
				historiaService.saveOrUpdate(hist);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return "redirect:/historia/historiaList";
	}
	
	
	
	

}
