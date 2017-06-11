package com.ipartek.proyectofinal.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.proyectofinal.controller.validator.CursoValidator;
import com.ipartek.proyectofinal.persistence.Curso;
import com.ipartek.proyectofinal.service.interfaces.CursoService;

@Controller
@RequestMapping(value = "/cursos")
public class CursoController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CursoController.class);
	private ModelAndView mav = null;
	
	@Autowired
	private CursoService cursoService;
	
	@Resource(name = "cursoValidator")
	CursoValidator validator;
	 
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAll() {
		LOGGER.info("Entra en el controller: getall");
		mav = new ModelAndView("cursos/cursos");
			List<Curso> cursos = cursoService.getAll();
		mav.addObject("listadoCursos", cursos);
			LOGGER.info("Cargada lista de cursos");
		return mav;
		}
	
	@RequestMapping(value = "/{id}")
	public ModelAndView getById(@PathVariable("id") long id) {
		mav = new ModelAndView("curso");
		mav.addObject("curso", cursoService.getById(id));
		LOGGER.info("Cargado curso.");
		return mav;
	}
	
	@RequestMapping(value = "/addCurso}")
	public String addCurso(Model model) {
	
		Curso curso = new Curso();
		curso.setActivo(true);
		model.addAttribute("curso", curso);
		LOGGER.info("Añadir curso.");
		return "curso";
	}
	
	@RequestMapping(value = "/editCurso/{codigo}")
	public ModelAndView editCurso(@PathVariable("codigo") long codigo) {
		
		mav = new ModelAndView("curso");
		mav.addObject("curso", cursoService.getById(codigo));
		LOGGER.info("Editar curso.");
		
		return mav;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCurso(Model model, @ModelAttribute("curso") 
							@Valid Curso curso,
							BindingResult bindingResult) {
		String destino = "";

		if (bindingResult.hasErrors()) {
			LOGGER.info("Los datos del curso tienen errores");
			destino = "curso";
		} else {
			destino = "redirect:/cursos";
			if (curso.getCodigo() > -1) {
				LOGGER.info("Editar curso: ",curso.toString());
				cursoService.update(curso);
			} else {
				LOGGER.info("Crear curso: ",curso.toString());
				cursoService.create(curso);
			}
		}
		return destino;
	}
	
	@RequestMapping(value = "/deleteCurso/{id}") 
	public String delete(@PathVariable("id") long id, Model model) {
		cursoService.delete(id);
			LOGGER.info("Borrar curso: ", cursoService.getById(id).getCodigo());
		return "cursos";
	}
}