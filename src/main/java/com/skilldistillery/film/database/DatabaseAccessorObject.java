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
	private String user = "student";
	private String pass = "student";

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

	@Override
	public Film findFilmById(int filmId) {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT * FROM film JOIN language ON language.id = film.language_id WHERE film.id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			rs = stmt.executeQuery();

//			System.out.println("TESTER GETTT***");

			while (rs.next()) {

				Film film = new Film(rs.getInt("id"), rs.getString("title"), rs.getString("description"),
						rs.getInt("release_year"), rs.getInt("language_id"), rs.getInt("rental_duration"),
						rs.getDouble("rental_rate"), rs.getInt("length"), rs.getDouble("replacement_cost"),
						rs.getString("rating"), rs.getString("name"));

				film.setActors(findActorsByFilmId(filmId));
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

		try {
			conn = DriverManager.getConnection(url, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "INSERT INTO film (title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating) "
					+ " VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

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

//

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

		List<String> filmsPastThousand = new ArrayList<>();
		try {
			conn = DriverManager.getConnection(url, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION

			String sql = "SELECT id, title from film where id > 1000";
			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.setInt(film.getId());
//			int updateCount = stmt.executeUpdate();

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				filmsPastThousand
						.add("ID #: " + Integer.toString(rs.getInt("id")) + " Title: " + rs.getString("title") + "  ");
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

	@Override
	public Film editFilm(Film film) {

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
//			String sql = "INSERT INTO film (title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating) "
//					+ " VALUES (?,?,?,?,?,?,?,?,?)";
			String sql = "UPDATE film SET title = ?, description = ?, release_year = ?, language_id = ?, rental_duration = ?, rental_rate = ?, length = ?, replacement_cost = ? WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setInt(4, film.getLanguageId());
			stmt.setInt(5, film.getRentalDuration());
			stmt.setDouble(6, film.getRentalRate());
			stmt.setInt(7, film.getLength());
			stmt.setDouble(8, film.getReplacementCost());
			stmt.setInt(9, film.getId());

			System.out.println(stmt);

			int updateCount = stmt.executeUpdate();

//			
			if (updateCount != 1) {
				film = null;
				System.out.println("NULLLLLIEFIED FILM");
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

	@Override
	public String findFilmCategory(Film film) {

		if (film == null) {
			return "";
		}

		String category = "";

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		// open connection & query
		try {
			conn = DriverManager.getConnection(url, user, pass);
//			String sql = "select * from film_actor JOIN actor ON film_actor.actor_id = actor.id where film_id = ?";
			String sql = "select category from film_list JOIN film ON film.id = film_list.fid where film.id = ?";
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, film.getId());
			rs = stmt.executeQuery();

			while (rs.next()) {

				category = rs.getString(1);
				film.setCategory(category);

			}

			return category;

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

}
