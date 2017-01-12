package edu.isep.JDBC;

import java.util.List;

public interface UniversiteRepository {

	Universite findOne(long id);

	Universite save(Universite universite);

	List<Universite> findAll();

	int update(Universite universite);

	int delete (Universite universite);

	int updateOne(Universite universite);

}
