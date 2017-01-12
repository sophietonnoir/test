package edu.isep.JDBC;

import java.util.List;

public interface ParcoursRepository {

	Parcours findOne(long id);

	Parcours findOne(String nomParcours);

	Parcours save(Parcours parcours);

	List<Parcours> findAll();

	List<Parcours> findAllBySql(String sql);

	int update(Parcours parcours);

	int delete (Parcours parcours);

	int updateOne(Parcours parcours);

}
