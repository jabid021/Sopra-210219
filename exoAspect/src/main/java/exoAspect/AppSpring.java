package exoAspect;

import org.springframework.beans.factory.annotation.Autowired;

import exoAspect.dao.DaoGeneric;

public class AppSpring {

	@Autowired
	private DaoGeneric dao;

	public void run(String[] args) {
		dao.insert(null);
		dao.findByKey();
	}
}
