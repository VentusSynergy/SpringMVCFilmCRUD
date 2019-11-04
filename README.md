## Spring MVC Film C.R.U.D. Project
Week 8 Homework Project for Skill Distillery

### Overview

* User Story 1

* User Story 2

* User Story 3

* User Story 4

* User Story 5

* User Story 6


## Overview

This program utilizes Java Database Connectivity (JDBC), MySQL & MySQL Workbench, as well as Spring Tool Suite
and Gradle. It implements a clean user interface which allows the user to Create Read Update or Delete entries
in a pre-populated database. The user can:

  1) Search for film by film Id
  2) Find film by keyword
  3) Edit film
  4) Create New Film
  5) Delete Film

### Search for film by ID
If the user selects **to search for film by ID**, the user enters the film ID. From there the ID
is passed from the form to the controller.
If there is a film in the database matching the film ID entered, it will be returned & displayed.
When a film is displayed, its title, year, rating, description, language, actor list,
and film category are displayed.


### Find film by keyword
If the user selects **to find film by keyword**, the user enters the keyword. The program then searches
the database's film table, looking for a match in the film title or film description.
If the database contains the entered keyword (or part of a keyword) in the film title or the film description,
it will return the film. Otherwise it will return NO FILM FOUND.


### Edit Film
If the user selects **edit film**, the id of the film is entered and user is redirected to an edit/delete
film page. The user then selects which fields to update. The fields are shown with their current values.
Some fields are required and are marked as such. Other fields use drop down boxes for fields that require
specific values (rating, language).  The program takes in the film id (primary key) of the film to be
updated, and uses that to do an UPDATE on the specified film.


### Create New Film
If the user selects **create new film**, the user is redirected to a create film page. The user then
enters all of the film information. Some fields are required and are marked as such. Other fields use
drop down boxes for fields that require specific values (rating, language). 
The program creates a new Film object & adds it to the database with an automatically generated Primary
Key.


### Delete Film
If the user selects **delete film**, the user enters the film id. The user then
presses delete film and is re-directed back to the home page. The program takes the id
and uses that to delete the film from the database if possible.


## Technologies/Topics Applied


