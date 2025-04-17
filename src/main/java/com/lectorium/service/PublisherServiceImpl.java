package com.lectorium.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lectorium.model.Publisher;
import com.lectorium.repo.IPublisherRepo;
import com.lectorium.repo.PublisherRepoImpl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
//@AllArgsConstructor
@RequiredArgsConstructor
public class PublisherServiceImpl implements IPublisherService {
	//@Autowired
	private final IPublisherRepo repo;

	@Override
	public Publisher save(Publisher publisher) throws Exception {
		return repo.save(publisher);
	}

	@Override
	public Publisher update(Publisher publisher, Integer id) throws Exception {
		// Evaluar el ID para actualizar luego
		publisher.setIdPublisher(id);
		return repo.save(publisher);
	}

	@Override
	public List<Publisher> findAll() throws Exception {
		return repo.findAll();
	}

	@Override
	public Publisher findById(Integer id) throws Exception {
		return repo.findById(id).orElse(new Publisher());
	}

	@Override
	public void delete(Integer id) throws Exception {
		repo.deleteById(id);
	}
	
	
	
	/*public PublisherServiceImpl(PublisherRepoImpl repo) {
		this.repo = repo;
	}*/

	/*
	@Override
	public Publisher saveAndValid(Publisher publisher) {
		//repo = new PublisherRepo();
		if(publisher.getIdPublisher() > 0) {
			return repo.save(publisher);
		}else {
			return new Publisher();
		}
	}
	*/
}
