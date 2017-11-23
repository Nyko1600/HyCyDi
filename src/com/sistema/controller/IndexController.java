package com.sistema.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.sistema.pojo.Usuario;
import com.sistema.service.UsuarioService;

@Controller
@SessionAttributes("usuarioSession")
public class IndexController {

	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping("/")
	public String showIndex(Model model){
		return "index";
	}
	
	@RequestMapping("/login")
	public String Login(Model model){
		//model.addAttribute("usuarioSession");
			return "login";
	}
	
	@RequestMapping("/sistema")
	public String showInicio(Model model){
		return "sistema";
	}
		
	@RequestMapping("/jQueryPrubas")
	public String showPruebas(Model model){
		return "jQueryPrubas";
	}
		
	@RequestMapping("/menuAdmin")
	public String showIndexAdmin(Model model, HttpServletRequest request){
		try {
			/*HttpSession session = request.getSession();
			String mail = (String) session.getAttribute("usuarioSession");
			Usuario us = usuarioService.findByMail(mail);
			session.setAttribute("usuarioSession",us);
			model.addAttribute("usuarioSession",us);*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			System.out.println("Error en showIndex....");
			e.printStackTrace();
		}

		return "menuAdmin";
	}
	
	@RequestMapping("/menuProfesional")
	public String showIndexProfesional(HttpServletRequest request){
		HttpSession session = request.getSession();
		String mail = (String) session.getAttribute("usuarioSession");
		Usuario us = usuarioService.findByMail(mail);
		session.setAttribute("usuarioSession",us);
		return "menuProfesional";
	}
	
	@RequestMapping("/logout")
	public String Logout(HttpServletRequest request,HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
			return "login";
	}
	
	
}