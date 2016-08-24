package com.sistema.controller;

import java.security.KeyException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.dsig.keyinfo.KeyValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		
	@RequestMapping("/jQueryPrubas")
	public String showPruebas(Model model){
		return "jQueryPrubas";
	}
		
	@RequestMapping("/menuAdmin")
	public String showIndexAdmin(Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		String mail = (String) session.getAttribute("userMail");
		System.out.println("MIAL: " + mail);
		Usuario us = usuarioService.findByMail(mail);
		System.out.println("US: " + us);
		//session.setAttribute("usuarioSession",us);
		model.addAttribute("usuarioSession",us);
		return "menuAdmin";
	}
	
	@RequestMapping("/menuProfesional")
	public String showIndexProfesional(HttpServletRequest request){
		HttpSession session = request.getSession();
		String mail = (String) session.getAttribute("userMail");
		Usuario us = usuarioService.findByMail(mail);
		session.setAttribute("usuarioSession",us);
		return "menuProfesional";
	}
	
	@RequestMapping("/login")
	public String Login(){
			return "login";
	}
	
	@RequestMapping("/logout")
	public String Logout(){
			return "index";
	}
	
	
}
