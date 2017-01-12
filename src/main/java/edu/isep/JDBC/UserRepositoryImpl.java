package edu.isep.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private JdbcOperations jdbc;

	private static final String SQL_INSERT = "insert into user (login, password, nom, nomFamille, prenom, type, numero, mail, IDPARCOURS) values (?,?,?,?,?,?,?,?,?)";
	private static final String SQL_UPDATE = "update user set login=?, password=?, nom=?, nomFamille=?, prenom=?, type=?, numero=?, mail=?, IDPARCOURS=?";
	private static final String SQL_UPDATE_ONE = "update user set login=?, password=?, nom=?, nomFamille=?, prenom=?, type=?, numero=?, mail=?, IDPARCOURS=? where userId=?";
	private static final String SQL_FIND_ONE = "select * from user where userId= ?";
	private static final String SQL_FIND_PARCOURS = "select * from user where IDPARCOURS= ?";
	private static final String SQL_FIND_PARCOURS_RESPO = "select * from user where type='respo' AND IDPARCOURS= ?";
	private static final String SQL_FIND_QUERY = "select * from user where ?=?";
	private static final String SQL_FIND_RESPOADMIN = "select * from user where type='respo' OR type='admin'";
	private static final String SQL_FIND_ALL = "select * from user order by nomFamille";
	//private static final String SQL_FIND_ALL_DATA = "select * from user order by nomFamille where IDPARCOURS=?";
	private static final String SQL_DELETE_ONE = "delete from user where userId=?";

	@Override
	public User findOne(long id) {
		return jdbc.queryForObject(SQL_FIND_ONE, new UserRowMapper(), id);
	}


	@Override
	public User findOneParcours(long id) {
		return jdbc.queryForObject(SQL_FIND_PARCOURS_RESPO, new UserRowMapper(), id);
	}



	@Override
	public User save(final User user) {

		KeyHolder holder = new GeneratedKeyHolder();

		int rows = jdbc.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement ps = conn.prepareStatement(SQL_INSERT, new String[]{"userId"});

				ps.setString(1, user.getLogin());
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getNom());
				ps.setString(4, user.getNomFamille());
				ps.setString(5, user.getPrenom());
				ps.setString(6, user.getType());
				ps.setString(7, user.getNumber());
				ps.setString(8, user.getMail());
				ps.setLong(	 9, user.getIdParcours());
				return ps;
			}
		}, holder);

		if(rows == 1) {	// success, so apply ID to the customer object
			user.setId((Long)holder.getKey());
			return user;
		}

		return null;

	}

	@Override
	public List<User> findAll() {
		return jdbc.query(SQL_FIND_ALL, new UserRowMapper());
	}
	public List<User> findAllRespoAdmin() {
		return jdbc.query(SQL_FIND_RESPOADMIN, new UserRowMapper());
	}
	@Override
	public List<User> findParcours(long id) {
		return jdbc.query(SQL_FIND_PARCOURS, new UserRowMapper(), id);
	}
	@Override
	public List<User> findAllBySql(String sql) {
		return jdbc.query(sql, new UserRowMapper());
	}
	@Override
	public List<User> findAll(long id) {
		return jdbc.query(SQL_FIND_PARCOURS, new UserRowMapper(),id);
	}

	@Override
	public int update(User user) {
		return jdbc.update(SQL_UPDATE, user.getLogin(), user.getPassword(), user.getNom(), user.getNomFamille(), user.getPrenom(), user.getType(), user.getNumber(), user.getMail(),user.getIdParcours());
	}
	@Override
	public int updateOne(User user) {
		return jdbc.update(SQL_UPDATE_ONE, user.getLogin(), user.getPassword(), user.getNom(), user.getNomFamille(), user.getPrenom(), user.getType(), user.getNumber(), user.getMail(),user.getIdParcours(), user.getId());
	}

	@Override
	public int delete(User user) {
		return jdbc.update(SQL_DELETE_ONE, user.getId());
	}

	private class UserRowMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int row) throws SQLException {

			return new User(rs.getInt("userId"), rs.getString("login"), rs.getString("password"), rs.getString("nom"), rs.getString("nomFamille"), rs.getString("prenom"), rs.getString("type"), rs.getString("numero"), rs.getString("mail"),rs.getInt("IDPARCOURS"));

		}

	}
}
