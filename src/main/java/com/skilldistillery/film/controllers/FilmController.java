package com.skilldistillery.film.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.database.DatabaseAccessorObject;

@Controller
public class FilmController {
	@Autowired
	private DatabaseAccessorObject dao;
	
	@RequestMapping(path = "findFilmById.do", method = RequestMethod.GET)
	public ModelAndView findFilmById() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/findFilmById.jsp");
		return mv;
		
	}
	@RequestMapping(path = "createFilm.do", method = RequestMethod.GET)
	public ModelAndView createFilm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/createFilm.jsp");
		return mv;
		
	}
}

	
	
	
