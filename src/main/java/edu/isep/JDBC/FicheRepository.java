package edu.isep.JDBC;

import java.util.List;

public interface FicheRepository {

	Fiche findOne(long id);

	Fiche findOne(User user);
	List findAllPromo();

	Fiche save(Fiche fiche);

	List< Fiche> findAll();

	int update(Fiche  fiche);

	int updateOne(Fiche fiche);


	int delete (Fiche fiche);

	List<Fiche> findAllBySql(String sql);
}
