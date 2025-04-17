package com.lectorium.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lectorium.model.Publisher;

public interface IPublisherRepo extends JpaRepository<Publisher, Integer> {
	// Publisher save(Publisher publisher);
}
