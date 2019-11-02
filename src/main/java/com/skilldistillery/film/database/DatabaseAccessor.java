package com.skilldistillery.film.database;

import java.util.List;

import com.skilldistillery.film.entities.*;

public interface DatabaseAccessor {
  public Film findFilmById(int filmId);
  
  public Actor findActorById(int actorId);
  public List<Actor> findActorsByFilmId(int filmId);
  public List<Film> findFilmByKeyword(String keyword);
  public Film createFilm(Film film);
  public Film runMenu();
  public boolean deleteFilm(Film film);
  public int returnLastId();
}
