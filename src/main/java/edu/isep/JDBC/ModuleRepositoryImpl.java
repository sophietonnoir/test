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
public class ModuleRepositoryImpl implements ModuleRepository {

	@Autowired
	private JdbcOperations jdbc;

	private static final String SQL_INSERT = "insert into module (NOMUNIV, DESCRIPTION, LIEN, STATUT, COMMENTAIRE, userId, IDPARCOURS) values (?,?,?,?,?,?,?)";
	private static final String SQL_UPDATE = "update module set NOMUNIV=?, DESCRIPTION=?, LIEN=?, STATUT=?, COMMENTAIRE=?, userId=?, IDPARCOURS=?";
	private static final String SQL_FIND_ONE = "select * from module where userId= ?";
	private static final String SQL_FIND_ONE_ID = "select * from module where id= ?";
	private static final String SQL_FIND_ALL = "select * from module order by id";
	private static final String SQL_DELETE_ONE = "delete from module where id=?";
	private static final String SQL_UPDATE_ONE = "update module set NOMUNIV=?, DESCRIPTION=?, LIEN=?, STATUT=?, COMMENTAIRE=?, userId=?, IDPARCOURS=? where id=?";

	@Override
	public Module findOne(long id) {
		return jdbc.queryForObject(SQL_FIND_ONE, new ModuleRowMapper(), id);
	}
	
	@Override
	public Module findOneId(long id) {
		return jdbc.queryForObject(SQL_FIND_ONE_ID, new ModuleRowMapper(), id);
	}

	@Override
	public List<Module> findAllBySql(String sql) {
		return jdbc.query(sql, new ModuleRowMapper());
	}

	@Override
	public Module save(final Module module) {

		KeyHolder holder = new GeneratedKeyHolder();

		int rows = jdbc.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement ps = conn.prepareStatement(SQL_INSERT, new String[]{"id"});

				ps.setString(1, module.getNomuniv());
				ps.setString(2, module.getDescription());
				ps.setString(3, module.getLien());
				ps.setString(4, module.getStatut());
				ps.setString(5, module.getCommentaire());
				ps.setLong(6, module.getUserId());
				ps.setLong(7, module.getIdparcours());

				return ps;
			}
		}, holder);

		if(rows == 1) {	// success, so apply ID to the customer object
			module.setId((Long)holder.getKey());
			return module;
		}

		return null;

	}

	@Override
	public List<Module> findAll() {
		return jdbc.query(SQL_FIND_ALL, new ModuleRowMapper());
	}

	@Override
	public int update(Module module) {
		return jdbc.update(SQL_UPDATE, module.getNomuniv(), module.getDescription(), module.getLien(),module.getStatut(), module.getCommentaire(), module.getUserId(), module.getIdparcours());
	}
	
	@Override
	public int updateOne(Module module) {
		return jdbc.update(SQL_UPDATE_ONE, module.getNomuniv(), module.getDescription(), module.getLien(),module.getStatut(), module.getCommentaire(), module.getUserId(), module.getIdparcours(), module.getId());
	}

	@Override
	public int delete(Module module) {
		return jdbc.update(SQL_DELETE_ONE, module.getId());
	}

	private class ModuleRowMapper implements RowMapper<Module> {

		@Override
		public Module mapRow(ResultSet rs, int row) throws SQLException {

			return new Module(rs.getInt("id"), rs.getString("NOMUNIV"), rs.getString("DESCRIPTION"), rs.getString("LIEN"), rs.getString("STATUT"), rs.getString("COMMENTAIRE"), rs.getInt("userId"), rs.getLong("IDPARCOURS"));

		}

	}
}
