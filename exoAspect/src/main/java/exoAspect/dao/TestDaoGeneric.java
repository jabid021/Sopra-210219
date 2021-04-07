package exoAspect.dao;

import org.springframework.stereotype.Component;

import exoAspect.annotation.Log;

@Component
public class TestDaoGeneric implements DaoGeneric {
	@Override
	@Log
	public void insert(Object o) {

	}

	@Override
	@Log
	public Object findByKey() {
		return null;
	}
}
