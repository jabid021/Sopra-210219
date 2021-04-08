package formation.dao;

import java.util.List;

public interface DaoGeneric<T, K> {
	void insert(T obj);

	T update(T obj);

	void delete(T obj);

	void deleteById(K id);

	T findById(K id);

	List<T> findAll();
}
