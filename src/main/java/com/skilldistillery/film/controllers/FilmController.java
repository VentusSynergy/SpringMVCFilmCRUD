package com.skilldistillery.film.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.database.DatabaseAccessorObject;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
	@Autowired
	private DatabaseAccessorObject dao;
	
	//finds film by Id, passing param filmId from index.html
	@RequestMapping(path="findFilmById.do", params="filmId", method=RequestMethod.GET)
	public ModelAndView findFilmById(@RequestParam("filmId") int p) {
		
		Film returnedFilm = dao.findFilmById(p);
		
		System.out.println("*******" + returnedFilm);//tester
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("film", returnedFilm);
		
		mv.setViewName("WEB-INF/findFilmById.jsp");//jsp displayed for results
		return mv;
	}
	
	@RequestMapping(path = "createFilm.do", method = RequestMethod.GET)
	public ModelAndView createFilm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/createFilm.jsp");
		return mv;
		
	}
}

	
	
	
