package com.sistema.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.sistema.pojo.Antecedentes;
import com.sistema.pojo.Familiares;
import com.sistema.pojo.Ficha;
import com.sistema.pojo.Fisiologicos;
import com.sistema.pojo.Ginecologicos;
import com.sistema.pojo.HabitosToxicos;
import com.sistema.pojo.HistoriaClinica;
import com.sistema.pojo.Patologicos;
import com.sistema.service.AntecedentesService;
import com.sistema.service.ConsultaService;
import com.sistema.service.DiagnosticoService;
import com.sistema.service.FichaService;
import com.sistema.service.HistoriaService;
import com.sistema.service.UsuarioService;

@Controller
@RequestMapping("/ficha")
@SessionAttributes("id_historia")
public class FichaController {

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

	@Autowired
	public AntecedentesService antecedentesService;

	@RequestMapping(value = "/{id_his}", method = RequestMethod.GET)
	public String showFicha(Model model, @PathVariable("id_his") int id_historia,
			@ModelAttribute("fichaForm") Ficha fichaForm,
			@ModelAttribute("resultado") String resultado) {

			try {
				List<Ficha> fichas = fichaService.findAllFichas(id_historia);
				model.addAttribute("fichas", fichas);
				model.addAttribute("id_historia", id_historia);
				model.addAttribute("fichaForm", fichaForm);
				model.addAttribute("resultado", resultado);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return "/jsp/historia/fichaForm";
		
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String showFichaSave(Model model, @ModelAttribute("fichaForm") Ficha fichaForm,
			@RequestParam("id_historia") int id_hist) {

		
			try {
				HistoriaClinica historia = historiaService.findById(id_hist);
				fichaForm.setHistoria(historia);
				fichaService.saveOrUpdate(fichaForm);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		return "/jsp/historia/fichaForm";
	}
	
	@RequestMapping(value = "/delete/{id_ficha}", method = RequestMethod.GET)
	public String showFichaSave(Model model, @PathVariable("id_ficha") int id_ficha,HttpServletRequest request,
			BindingResult result,
			RedirectAttributes ra) {

		
			try {
				Ficha ficha = fichaService.findById(id_ficha);
				fichaService.delete(ficha);
				ra.addFlashAttribute("resultado", "Ficha Eliminada Correctamente");
			} catch (Exception e) {
				ra.addFlashAttribute("resultado", "Error al Eliminar Ficha");
				e.printStackTrace();
			}
			
		return "redirect:/ficha/"+request.getSession().getAttribute("id_historia");
	}
	

	@RequestMapping(value = "/antecedentes/{id_ficha}", method = RequestMethod.GET)
	public String showAntecedentes(Model model, @PathVariable("id_ficha") int id_ficha,
			@ModelAttribute("habitosForm") HabitosToxicos habitosForm
			/*@ModelAttribute("familiaresForm") Familiares familiaresForm*/) {

			try {
				model.addAttribute("habitos", habitosForm);
				//model.addAttribute("familiares", familiaresForm);
				model.addAttribute("id_ficha", id_ficha);
				model.addAttribute("id_antecedentes",0);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return "/jsp/historia/antecedentesForm";
	}

	@RequestMapping(value = "/antecedentes/save", method = RequestMethod.POST)
	public String AntecedentesSave(Model model, @RequestParam("id_antecedentes") String id_antecedentes,
			@RequestParam("id_ficha") int id_ficha,
			@RequestParam("id_habitos") String id_habitos,
			//@RequestParam("id_familiares") int id_familiares,
			@RequestParam("alcohol") String alcohol,
			@RequestParam("tabaco") String tabaco,
			@RequestParam("drogas") String drogas,
			@RequestParam("infusiones") String infusiones,
			@RequestParam("otrosHabitos") String otrosHabitos,
			@RequestParam("descripcionHabitos") String descripcionHabitos,
			@RequestParam("diabetes") String diabetes,
			@RequestParam("hipertension") String hipertension,
			@RequestParam("tuberculosis") String tuberculosis,
			@RequestParam("gemelarFamiliar") String gemelarFamiliar,
			@RequestParam("otrosFamiliar") String otrosFamiliar,
			//@RequestParam("id_fisiologia") String id_fisiologia,
			@RequestParam("alimentacion") String alimentacion,
			@RequestParam("dipsia") String dipsia,
			@RequestParam("diuresis") String diuresis,
			@RequestParam("catarsis") String catarsis,
			@RequestParam("somnia") String somnia,
			@RequestParam("otrosFisiologicos") String otrosFisiologicos,
			//@RequestParam("id_patologicos") String id_patologicos,
			@RequestParam("infancia") String infacia,
			@RequestParam("adulto") String adulto,
			@RequestParam("DBT") String DBT,
			@RequestParam("HTA") String HTA,
			@RequestParam("TBC") String TBC,
			@RequestParam("gemelarPatologico") String gemelarPatologico,
			@RequestParam("quirurgicos") String quirurgicos,
			@RequestParam("traumatologicos") String traumatologicos,
			@RequestParam("alergicos") String alergicos,
			@RequestParam("otrosPatologicos") String otrosPatologicos,
			//@RequestParam("id_ginecologicos") int id_ginecologicos,
			@RequestParam(value="FUM" , required=false) Date FUM,
			@RequestParam(value="FPP" , required=false) Date FPP,
			@RequestParam("edadGestacional") int edadGestacional,
			@RequestParam("menarca") int menarca,
			@RequestParam("RM") String RM,
			@RequestParam("IRS") int IRS,
			@RequestParam("nroParejas") int  nroParejas,
			@RequestParam("flujoGenital") String flujoGenital,
			@RequestParam("gestas") int gestas,
			@RequestParam("partos") int partos,
			@RequestParam("cesareas") int cesareas,
			@RequestParam("abortos") int abortos,
			@RequestParam("descripcionGinecologicos") String descripcionGinecologico) {

		
			try {
				Ficha ficha = fichaService.findById(id_ficha);
				Antecedentes ant = new Antecedentes();
				ant.setFicha(ficha);

				HabitosToxicos hab = new HabitosToxicos(alcohol.substring(0, 2),tabaco.substring(0, 2),drogas.substring(0, 2),infusiones.substring(0, 2),otrosHabitos,descripcionHabitos,ant);
				Familiares familiares = new Familiares(diabetes.substring(0, 2), hipertension.substring(0, 2), tuberculosis.substring(0, 2), gemelarFamiliar.substring(0, 2), otrosFamiliar, ant);
				Fisiologicos fisiologicos = new Fisiologicos(alimentacion, dipsia.substring(0, 2), diuresis.substring(0, 2), catarsis.substring(0, 2), somnia.substring(0, 2), otrosFisiologicos, ant);
				Patologicos patologico = new Patologicos(infacia, adulto, DBT.substring(0, 2), HTA.substring(0, 2), TBC.substring(0, 2), gemelarPatologico.substring(0, 2), quirurgicos, traumatologicos, alergicos, otrosPatologicos, ant);
				Ginecologicos ginecologicos = new Ginecologicos(FUM, FPP, edadGestacional, menarca, RM, IRS, nroParejas, flujoGenital, gestas, partos, cesareas, abortos, descripcionGinecologico, ant);
				
				antecedentesService.saveOrUpdateAntecedentes(ant);
				antecedentesService.saveOrUpdateHabitos(hab);
				antecedentesService.saveOrUpdateFamiliares(familiares);
				antecedentesService.saveOrUpdateFisiologicos(fisiologicos);
				antecedentesService.saveOrUpdatePatologicos(patologico);
				antecedentesService.saveOrUpdateGinecologicos(ginecologicos);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		return "/jsp/historia/antecedentesForm";
		}

	
	@RequestMapping(value = "/HabitoSubmit", method = RequestMethod.POST)
	@ResponseBody
	public String saveHabitos(Model model,@RequestBody String json,@RequestParam("id_ficha") int id_ficha
			){
	
		//Ficha ficha = fichaService.findById(id_ficha);	
		return "";

	}


}
