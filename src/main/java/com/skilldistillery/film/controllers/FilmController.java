package com.skilldistillery.film.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FilmController {
	
	
	@RequestMapping(path = "createFilm.do", method = RequestMethod.GET)
	public ModelAndView createFilm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/createFilm.jsp");
		return mv;
		
	}
}

	
	
	
