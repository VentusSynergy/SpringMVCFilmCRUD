package com.skilldistillery.film.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.skilldistillery.film.entities.*;

@Component
public class DatabaseAccessorObject implements DatabaseAccessor {

	private static final String url = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";

	static {// had to add this static block to connect to DB
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DatabaseAccessorObject dbo = new DatabaseAccessorObject();
		dbo.runMenu();
	}

//	private String description;
//	private Integer releaseYear;
//	private int languageId;
//	private String language;
//	private int rentalDuration;
//	private double rentalRate;
//	private int length;
//	private double replacementCost;
//	private String rating;

//	public Film runMenu() {
//
//		System.out.println("Enter film info...");
//		System.out.println("Enter film title: ");
//		String filmTitle = sc.nextLine();
//
//		System.out.println("Enter film description ");
//		String filmDescription = sc.nextLine();
//
//		System.out.println("Enter film releaseYear ");
//		Integer relYear = sc.nextInt();
//
//		System.out.println("Enter film language ID: ");
//		int languageId = sc.nextInt();
//
//		System.out.println("Enter film rental duration: ");
//		int rentalDuration = sc.nextInt();
//
//		System.out.println("Enter film rental rate: ");
//		double rentalRate = sc.nextDouble();
//
//		System.out.println("Enter film length: ");
//		int length = sc.nextInt();
//
//		System.out.println("Enter film replacement cost: ");
//		double replacementCost = sc.nextDouble();
//
//		System.out.println("Enter film rating ");
//		String rating = sc.next();
//
//		Film film = new Film(filmTitle, filmDescription, relYear, languageId, rentalDuration, rentalRate, length,
//				replacementCost, rating);
//
//		Film newCreatedFilm = createFilm(film);
//
//		System.out.println(newCreatedFilm);
//
//		return newCreatedFilm;
//
//	}

	@Override
	public Film findFilmById(int filmId) {

		String user = "root";
		String pass = "root";
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		// open connection & query
//		System.out.println("TEST F");
		try {
			conn = DriverManager.getConnection(url, user, pass);
//			System.out.println("Connection..");
			// String sql = "SELECT * FROM film WHERE id = ?";
			String sql = "SELECT * FROM film JOIN language ON language.id = film.language_id WHERE film.id = ?";
			stmt = conn.prepareStatement(sql);
//			System.out.println("Statement..");
			stmt.setInt(1, filmId);
//			System.out.println("Set int..");
			rs = stmt.executeQuery();

//			System.out.println("TESTER GETTT***");

			while (rs.next()) {

				Film film = new Film(rs.getInt("id"), rs.getString("title"), rs.getString("description"),
						rs.getInt("release_year"), rs.getInt("language_id"), rs.getInt("rental_duration"),
						rs.getDouble("rental_rate"), rs.getInt("length"), rs.getDouble("replacement_cost"),
						rs.getString("rating"), rs.getString("name"));

				film.setActors(findActorsByFilmId(filmId));
//				System.out.println("***********************************");
//				System.out.println(rs.getString("id") + " " + rs.getString("title"));
//				System.out.println("***********************************");
				return film;
			}

		} catch (SQLException e) {
			System.out.println("**Database connection error**");
			e.printStackTrace();
		}
		// close
		finally {
			try {
				if (rs != null) {
					rs.close();
				} // Not needed, stmt.close() will close it; but good practice
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.err.println(sqle);
			}
		}

		return null;
	}

	@Override
	public Actor findActorById(int actorId) {

		String user = "student";
		String pass = "student";
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		// open connection & query
		try {
			conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT * FROM actor WHERE id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			rs = stmt.executeQuery();

			while (rs.next()) {

				Actor actor = new Actor(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"));

				// System.out.println(rs.getString("id") + " " + rs.getString("title"));
				return actor;
			}

		} catch (SQLException e) {
			System.out.println("**Database connection error**");
			e.printStackTrace();
		}
		// close
		finally {
			try {
				if (rs != null) {
					rs.close();
				} // Not needed, stmt.close() will close it; but good practice
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.err.println(sqle);
			}
		}

		return null;

	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {

		List<Actor> actorList = new ArrayList<>();
		String user = "student";
		String pass = "student";
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		// open connection & query
		try {
			conn = DriverManager.getConnection(url, user, pass);
			String sql = "select * from film_actor JOIN actor ON film_actor.actor_id = actor.id where film_id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			rs = stmt.executeQuery();

			while (rs.next()) {

				Actor actor = new Actor(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"));
				actorList.add(actor);
				// System.out.println(rs.getString("id") + " " + rs.getString("title"));
			}

			return actorList;

		} catch (SQLException e) {
			System.out.println("**Database connection error**");
			e.printStackTrace();
		}
		// close
		finally {
			try {
				if (rs != null) {
					rs.close();
				} // Not needed, stmt.close() will close it; but good practice
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.err.println(sqle);
			}
		}

		return null;

	}

	@Override
	public List<Film> findFilmByKeyword(String keyword) {

		List<Film> filmList = new ArrayList<>();
		String user = "student";
		String pass = "student";
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		// open connection & query
		try {
			conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT * FROM film JOIN language ON language.id = film.language_id WHERE title LIKE ? OR description LIKE ?";
			stmt = conn.prepareStatement(sql);
			// stmt.setInt(1, filmId);
			stmt.setString(1, ("%" + keyword + "%"));
			stmt.setString(2, ("%" + keyword + "%"));
			rs = stmt.executeQuery();

			while (rs.next()) {

				Film film = new Film(rs.getInt("film.id"), rs.getString("title"), rs.getString("description"),
						rs.getInt("release_year"), rs.getInt("language_id"), rs.getInt("rental_duration"),
						rs.getDouble("rental_rate"), rs.getInt("length"), rs.getDouble("replacement_cost"),
						rs.getString("rating"), rs.getString("name"));

				film.setActors(findActorsByFilmId(rs.getInt("film.id")));

				filmList.add(film);
				// System.out.println(rs.getString("id") + " " + rs.getString("title"));
			}

			return filmList;

		} catch (SQLException e) {
			System.out.println("**Database connection error**");
			e.printStackTrace();
		}
		// close
		finally {
			try {
				if (rs != null) {
					rs.close();
				} // Not needed, stmt.close() will close it; but good practice
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.err.println(sqle);
			}
		}

		return null;

	}

	@Override
	public Film createFilm(Film film) {

		System.out.println("***IN DAO");

		Connection conn = null;
		String user = "root";
		String pass = "root";
		try {
			conn = DriverManager.getConnection(url, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "INSERT INTO film (title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating) "
					+ " VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

//			private String description;
//			private Integer releaseYear;
//			private int languageId;
//			private String language;
//			private int rentalDuration;
//			private double rentalRate;
//			private int length;
//			private double replacementCost;
//			private String rating;

			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setInt(4, film.getLanguageId());
			stmt.setInt(5, film.getRentalDuration());
			stmt.setDouble(6, film.getRentalRate());
			stmt.setInt(7, film.getLength());
			stmt.setDouble(8, film.getReplacementCost());
			stmt.setString(9, film.getRating());

			System.out.println(stmt);

			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				ResultSet keys = stmt.getGeneratedKeys();
				if (keys.next()) {
					int newFilmId = keys.getInt(1);
					film.setId(newFilmId);
					if (film.getActors() != null && film.getActors().size() > 0) {
						sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
						stmt = conn.prepareStatement(sql);
						for (Actor actor : film.getActors()) {
							stmt.setInt(1, newFilmId);
							stmt.setInt(2, actor.getId());
							updateCount = stmt.executeUpdate();
						}
					}
				}
			} else {
				film = null;
			}
			conn.commit(); // COMMIT TRANSACTION
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			throw new RuntimeException("Error inserting actor " + film);
		}

		return film;
	}

	public boolean deleteFilm(Film film) {
		Connection conn = null;
		String user = "root";
		String pass = "root";
		try {
			conn = DriverManager.getConnection(url, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "DELETE FROM film_actor WHERE film_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, film.getId());
			int updateCount = stmt.executeUpdate();

			sql = "DELETE FROM film WHERE id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, film.getId());
			updateCount = stmt.executeUpdate();
			conn.commit(); // COMMIT TRANSACTION
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		return true;
	}

//	public Film editFilm(Film film) {
//		Connection conn = null;
//		String user = "root";
//		String pass = "root";
//		try {
//			conn = DriverManager.getConnection(url, user, pass);
//			conn.setAutoCommit(false); // START TRANSACTION
//			String sql = "DELETE FROM film_actor WHERE film_id = ?";
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.setInt(1, film.getId());
//			int updateCount = stmt.executeUpdate();
//
//			sql = "DELETE FROM film WHERE id = ?";
//			stmt = conn.prepareStatement(sql);
//			stmt.setInt(1, film.getId());
//			updateCount = stmt.executeUpdate();
//			conn.commit(); // COMMIT TRANSACTION
//		} catch (SQLException sqle) {
//			sqle.printStackTrace();
//			if (conn != null) {
//				try {
//					conn.rollback();
//				} catch (SQLException sqle2) {
//					System.err.println("Error trying to rollback");
//				}
//			}
//			return false;
//		}
//		return true;
//	}

	@Override
	public Film runMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> returnGreaterThanThousand() {
		// TODO Auto-generated method stub

		Film films = new Film();

		Connection conn = null;
		String user = "root";
		String pass = "root";
		List<String> filmsPastThousand = new ArrayList<>();
		try {
			conn = DriverManager.getConnection(url, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION

			String sql = "SELECT title from film where id > 1000";
			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.setInt(film.getId());
//			int updateCount = stmt.executeUpdate();

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				filmsPastThousand.add(rs.getString("title"));
			}
			System.out.println(filmsPastThousand + "FILMS PAST 10000");
			films.setFilmTitlePastThousand(filmsPastThousand);

			conn.commit(); // COMMIT TRANSACTION
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return null;
		}
//		return filmsPastThousand;
		return filmsPastThousand;

	}

	public boolean editThisFilm(Film edit) {
		String user = "root";
		String pass = "root";

		Connection conn = null;
		PreparedStatement stmt = null;
		
		String sql = "UPDATE film SET title = ?, description = ?, release_year = ?, language_id = ?,length = ?,  rating = ? WHERE film.id = ?";

		try {
			conn = DriverManager.getConnection(url, user, pass);
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, edit.getTitle());
			stmt.setString(2, edit.getDescription());
			stmt.setInt(3, edit.getReleaseYear());
			stmt.setInt(4, edit.getLanguageId());
			stmt.setInt(5, edit.getLength());
			stmt.setString(6, edit.getRating());
			stmt.setInt(7, edit.getId());

			int result = stmt.executeUpdate();

			conn.commit();

			conn.close();
			stmt.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();

			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("\nError rolling back...\n");
				}
			}
			return false;
		}
		return true;
	}

}
