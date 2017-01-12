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
public class UniversiteRepositoryImpl implements UniversiteRepository {

	@Autowired
	private JdbcOperations jdbc;

	private static final String SQL_INSERT = "insert into universite (NOMUNIV, LIENUNIV) values (?,?)";
	private static final String SQL_UPDATE = "update universite set NOMUNIV=?, LIENUNIV=?";
	private static final String SQL_UPDATE_ONE = "update universite set NOMUNIV=?, LIENUNIV=? where IDUNIV=?";
	private static final String SQL_FIND_ONE = "select * from universite where IDUNIV= ?";
	private static final String SQL_FIND_ALL = "select * from universite order by NOMUNIV";
	private static final String SQL_DELETE_ONE = "delete from universite where IDUNIV=?";

	@Override
	public Universite findOne(long id) {
		return jdbc.queryForObject(SQL_FIND_ONE, new UniversiteRowMapper(), id);
	}

	@Override
	public Universite save(final Universite universite) {

		KeyHolder holder = new GeneratedKeyHolder();

		int rows = jdbc.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement ps = conn.prepareStatement(SQL_INSERT, new String[]{"IDUNIV"});

				ps.setString(1, universite.getNomuniv());
				ps.setString(2, universite.getLienuniv());


				return ps;
			}
		}, holder);

		if(rows == 1) {	// success, so apply ID to the customer object
			universite.setId((Long)holder.getKey());
			return universite;
		}

		return null;

	}

	@Override
	public List<Universite> findAll() {
		return jdbc.query(SQL_FIND_ALL, new UniversiteRowMapper());
	}

	@Override
	public int update(Universite universite) {
		return jdbc.update(SQL_UPDATE, universite.getNomuniv(), universite.getLienuniv());
	}
	
	@Override
	public int updateOne(Universite universite) {
		return jdbc.update(SQL_UPDATE_ONE, universite.getNomuniv(), universite.getLienuniv(), universite.getId());
	}

	@Override
	public int delete(Universite universite) {
		return jdbc.update(SQL_DELETE_ONE, universite.getId());
	}

	private class UniversiteRowMapper implements RowMapper<Universite> {

		@Override
		public Universite mapRow(ResultSet rs, int row) throws SQLException {

			return new Universite(rs.getInt("IDUNIV"), rs.getString("NOMUNIV"), rs.getString("LIENUNIV")); 

		}

	}
}
