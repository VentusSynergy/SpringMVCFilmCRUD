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
//	@RequestMapping(path = "createFilm.do", params="title, description", params="relYear", params="languageId", params="rentalDuration", params="rentalRate", params="length", params="replacementCost", params="rating", method = RequestMethod.GET)
	@RequestMapping(path = "createFilm.do", method = RequestMethod.POST)
	public ModelAndView createFilm(Film film) {
		System.out.println("***IN CONTROLLER");
		
//		Film film = new Film(title, description, relYear, languageId, rentalDuration, rentalRate, length, replacementCost, rating);
		
		Film returnedFilm = dao.createFilm(film);
		
		ModelAndView mv = new ModelAndView();
		
		
		mv.addObject("film", returnedFilm);
		
		mv.setViewName("WEB-INF/results.jsp");
		return mv;
		
	}
	
	@RequestMapping(path = "deleteFilm.do", params=("title"), method = RequestMethod.POST)
	public ModelAndView deleteFilm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/deletFilm.jsp");
		return mv;
	}
	
	
}

	
	
	
