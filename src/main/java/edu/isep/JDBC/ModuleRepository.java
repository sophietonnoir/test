package edu.isep.JDBC;

import java.util.List;

public interface ModuleRepository {

	Module findOne(long id);

	Module save(Module module);

	List<Module> findAll();

	int update(Module module);

	int delete (Module module);

	List<Module> findAllBySql(String sql);

	int updateOne(Module module);

	Module findOneId(long id);

}
