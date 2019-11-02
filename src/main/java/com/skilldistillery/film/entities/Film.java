package com.skilldistillery.film.entities;

import java.util.ArrayList;
import java.util.List;

public class Film {

	private Integer id;
	private String title;
	private String description;
	private Integer releaseYear;
	private int languageId;
	private String language;
	private int rentalDuration;
	private double rentalRate;
	private int length;
	private double replacementCost;
	private String rating;
	private List<Actor> actors = new ArrayList<>();
	// private List<Actor> formattedActors = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + languageId;
		result = prime * result + length;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((releaseYear == null) ? 0 : releaseYear.hashCode());
		result = prime * result + rentalDuration;
		long temp;
		temp = Double.doubleToLongBits(replacementCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (languageId != other.languageId)
			return false;
		if (length != other.length)
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (releaseYear == null) {
			if (other.releaseYear != null)
				return false;
		} else if (!releaseYear.equals(other.releaseYear))
			return false;
		if (rentalDuration != other.rentalDuration)
			return false;
		if (Double.doubleToLongBits(replacementCost) != Double.doubleToLongBits(other.replacementCost))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public Film(Integer id, String title, String description, Integer releaseYear, int languageId, int rentalDuration,
			double rentalRate, int length, double replacementCost, String rating, String language) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.language = language;
	}

	public Film(String title, String description, Integer releaseYear, int languageId, int rentalDuration,
			double rentalRate, int length, double replacementCost, String rating) {
		super();
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
	}

	public Film(String title, String description, Integer releaseYear, int rentalDuration, double rentalRate,
			int length, double replacementCost, String rating) {
		super();
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.rentalDuration = rentalDuration;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
	}

	public Film(Integer id, String title, String description, Integer releaseYear, int rentalDuration,
			double rentalRate, int length, double replacementCost, String rating, List<Actor> actors, String language) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.rentalDuration = rentalDuration;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.actors = actors;
		this.language = language;
	}

	public Film(Integer id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public Film(int i, String string, String string2, int j, String string3, int k, double d, int l, double e,
			String string4, String string5, List<Actor> list) {
		super();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nFilm ID: ");
		builder.append(id);
		builder.append("\nFilm title: ");
		builder.append(title);
		builder.append("\nRelease Year: ");
		builder.append(releaseYear);
		builder.append("\nRating: ");
		builder.append(rating);
		builder.append("\nDescription: ");
		builder.append(description);
		builder.append("\nLanguage: ");
		builder.append(language);
		builder.append("\nActors: \n");
		builder.append(actors + "\n");
//		builder.append(", languageId=");
//		builder.append(languageId);
//		builder.append(", rentalDuration=");
//		builder.append(rentalDuration);
//		builder.append(", length=");
//		builder.append(length);
//		builder.append(", replacementCost=");
//		builder.append(replacementCost);
//		builder.append(", actors = ");
//		builder.append(actors);
//		builder.append("]");
		return builder.toString();
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

//	public void formatActorList() {
//		formattedActors = new ArrayList<>();
//		
//		for (Actor a : actors) {
//			formattedActors.ad
//		}
//	}

}
