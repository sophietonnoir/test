package edu.isep.JDBC;

import java.util.List;

public interface TemoignageRepository {

	Temoignage findOne(long id);

	Temoignage save(Temoignage temoignage);

	List<Temoignage> findAll();
	List<Temoignage> findAll(String parcoursName);

	int update(Temoignage temoignage);
	int updateOne(Temoignage temoignage);

	int delete (Temoignage temoignage);

	List<Temoignage> findAllBySql(String sql);

}
