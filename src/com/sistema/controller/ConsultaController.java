package com.sistema.controller;


	import java.util.ArrayList;
	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.validation.BindingResult;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


	import com.sistema.pojo.Consulta;
	import com.sistema.pojo.Diagnostico;
	import com.sistema.pojo.Ficha;
	//import com.sistema.pojo.HabitosToxicos;
	import com.sistema.pojo.HistoriaClinica;
	import com.sistema.pojo.Usuario;
	import com.sistema.service.ConsultaService;
	import com.sistema.service.DiagnosticoService;
	import com.sistema.service.DomicilioService;
	import com.sistema.service.FichaService;
	import com.sistema.service.HistoriaService;
	import com.sistema.service.UsuarioService;

	@Controller
	@RequestMapping("/consultas")
	public class ConsultaController {

		
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
		
		@RequestMapping(value="/listarConsultas",method=RequestMethod.GET)
		public String showConsultas(Model model,@ModelAttribute("consultaForm") Consulta consultaForm){
			try {
				List<HistoriaClinica> historias = historiaService.findAllHistorias();
				model.addAttribute("historias",historias);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "/jsp/historia/consultasList";
		}
		
		@RequestMapping(value="/{id_his}",method=RequestMethod.GET)
		public String showConsulta(Model model, @PathVariable("id_his") int id_historia,
				@ModelAttribute("consultaForm") Consulta consultaForm){
			
				try {
					Consulta consulta = new Consulta();
					model.addAttribute("id_historia", id_historia);
					model.addAttribute("consultaForm",consultaForm);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			return "/jsp/historia/consultaForm";
		}
		
		@RequestMapping(value="/save",method=RequestMethod.POST)
		public String showConsultaSave(Model model, 
				@RequestParam("id_historia")int id_hist,
				@RequestParam("usuario")String usuarioMail,
				@RequestParam("anamnesis")String anamnesis,
				@RequestParam("exploracion")String exploracion,
				@RequestParam("observaciones")String observaciones,
				@RequestParam("titulo")String titulo,
				@RequestParam("tratamiento")String tratamiento,
				@RequestParam("descripcion")String descripcion){
			
			
				try {
					HistoriaClinica historia = historiaService.findById(id_hist);
					Diagnostico diagnostico = new Diagnostico(titulo,tratamiento,descripcion);
					Usuario usuario = usuarioService.findByMail(usuarioMail);
					Consulta consulta = new Consulta(anamnesis, exploracion, observaciones, historia, usuario, diagnostico);
					diagnostico.setConsulta(consulta);

					consultaService.saveOrUpdate(consulta);
					diagnosticoService.saveOrUpdate(diagnostico);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			return "/jsp/historia/consultaForm";
		}
		
		
		@RequestMapping(value="/searchByName",method=RequestMethod.GET)
		public ModelAndView findAllUser(Model model,@RequestParam("apellido") String apellido){
			
			ModelAndView modelo;
			try {
				List<HistoriaClinica> historias = historiaService.findByName(apellido);
				modelo = new ModelAndView("/jsp/historia/consultasList");
				modelo.addObject("historias",historias);
				return modelo;
			} catch (Exception e) {
				e.printStackTrace();
				modelo = new ModelAndView("/jsp/historia/consultasList");
				return modelo;
			}
						
		}
		
		
	}
	
	
	
	
	
