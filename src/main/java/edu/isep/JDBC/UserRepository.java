package edu.isep.JDBC;

import java.util.List;

public interface UserRepository {

	User findOne(long id);

	User save(User user);

	List<User> findAll();
	List<User> findAllRespoAdmin();
	List<User> findAll(long id);
	List<User> findAllBySql(String sql);

	int update(User user);

	int updateOne(User user);

	int delete (User user);

	List<User> findParcours(long id);

	User findOneParcours(long id);

}
