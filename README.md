## Spring MVC Film C.R.U.D. Project
Week 8 Homework Project for Skill Distillery

### Overview

* User Story 1
A user can enter a Film's ID and see the details of the film in a web page. If the film is not found, they see an appropriate message.

* User Story 2
A user can choose to add a new film. They can enter all the properties of the film. Their input will be used to create Film object, which the DAO implementation will save in the database. If the insert fails, the user is informed of this.

* User Story 3
When a user retrieves a film, they have the option of deleting it. If they delete the film, it is removed from the database. If the delete fails (such as, due to child records), the user is informed of this.

Note: It is not necessary to be able to delete existing films, which have child records in various tables. Test your delete functionality using new films you've created via User Story 2.

* User Story 4
When a user retrieves a film, they have the option of editing it. If they choose this, all the film's current properties are displayed in a form, allowing them to change any property except the film's ID. When they submit the form, that film's record is updated in the database. If the update fails, the user is informed of this.

* User Story 5
A user can search for films by keyword/pattern in title or description. From the resulting list of films, the user can choose to update or delete a record.

* User Story 6
When a film's details are displayed, its actors and categories are also listed.


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


