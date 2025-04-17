package com.lectorium.service;

import java.util.List;

import com.lectorium.model.Publisher;

public interface IPublisherService {
	//Publisher saveAndValid(Publisher publisher);
	Publisher save(Publisher publisher) throws Exception;
	Publisher update(Publisher publisher, Integer id) throws Exception;
	List<Publisher> findAll() throws Exception;
	Publisher findById(Integer id) throws Exception;
	void delete(Integer id) throws Exception;
}
