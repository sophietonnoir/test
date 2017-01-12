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
public class ParcoursRepositoryImpl implements ParcoursRepository {

	@Autowired
	private JdbcOperations jdbc;

	private static final String SQL_INSERT = "insert into parcours (NOMPARCOURS, DESCRIPTION) values (?,?)";
	private static final String SQL_UPDATE = "update parcours set NOMPARCOURS=?, DESCRIPTION=?";
	private static final String SQL_UPDATE_ONE = "update parcours set NOMPARCOURS=?, DESCRIPTION=? where IDPARCOURS=?";
	private static final String SQL_FIND_NAME = "select * from parcours where NOMPARCOURS= ?";
	private static final String SQL_FIND_ONE = "select * from parcours where IDPARCOURS= ?";
	private static final String SQL_FIND_ALL = "select * from parcours order by NOMPARCOURS";
	private static final String SQL_DELETE_ONE = "delete from parcours where IDPARCOURS=?";

	@Override
	public Parcours findOne(long id) {
		return jdbc.queryForObject(SQL_FIND_ONE, new ParcoursRowMapper(), id);
	}
	@Override
	public Parcours findOne(String NOMPARCOURS) {
		return jdbc.queryForObject(SQL_FIND_NAME, new ParcoursRowMapper(), NOMPARCOURS);
	}


	@Override
	public Parcours save(final Parcours parcours) {

		KeyHolder holder = new GeneratedKeyHolder();

		int rows = jdbc.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement ps = conn.prepareStatement(SQL_INSERT, new String[]{"IDPARCOURS"});

				ps.setString(1, parcours.getNomparcours());
				ps.setString(2, parcours.getDescription());
				return ps;
			}
		}, holder);

		if(rows == 1) {	// success, so apply ID to the customer object
			parcours.setId((Long)holder.getKey());
			return parcours;
		}

		return null;

	}

	@Override
	public List<Parcours> findAll() {
		return jdbc.query(SQL_FIND_ALL, new ParcoursRowMapper());
	}

	@Override
	public List<Parcours> findAllBySql(String sql) {
		return jdbc.query(sql,new ParcoursRowMapper());
	}
	@Override
	public int update(Parcours parcours) {
		return jdbc.update(SQL_UPDATE, parcours.getNomparcours(), parcours.getDescription());
	}
	
	@Override
	public int updateOne(Parcours parcours) {
		return jdbc.update(SQL_UPDATE_ONE, parcours.getNomparcours(), parcours.getDescription(), parcours.getId());
	}

	@Override
	public int delete(Parcours parcours) {
		return jdbc.update(SQL_DELETE_ONE, parcours.getId());
	}

	private class ParcoursRowMapper implements RowMapper<Parcours> {

		@Override
		public Parcours mapRow(ResultSet rs, int row) throws SQLException {

			return new Parcours(rs.getInt("IDPARCOURS"), rs.getString("NOMPARCOURS"), rs.getString("DESCRIPTION"));

		}

	}
}
