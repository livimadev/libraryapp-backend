package com.lectorium.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lectorium.model.Publisher;
import com.lectorium.service.IPublisherService;

import lombok.RequiredArgsConstructor;

// https://localhost:9090/publishers
@RestController
@RequestMapping("/publishers")
//@AllArgsConstructor
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PublisherController {
	//@Autowired
	private final IPublisherService service;
	
	@GetMapping
	public List<Publisher> findAll() throws Exception{
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Publisher findById(@PathVariable("id") Integer id) throws Exception{
		return service.findById(id);
	}

	@PostMapping
	public Publisher save(@RequestBody Publisher publisher) throws Exception{
		return service.save(publisher);
	}
	
	@PutMapping("/{id}")
	public Publisher update(@PathVariable("id") Integer id, @RequestBody Publisher publisher) throws Exception{
		return service.update(publisher, id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) throws Exception{
		service.delete(id);
	}
	/*
	public PublisherController(PublisherServiceImpl service) {
		this.service = service;
	}
	*/

	/*
	@GetMapping
	public Publisher savePublisher() {
		//service = new PublisherService();
		return service.saveAndValid(new Publisher());
	}
	*/
	/*
	@GetMapping
	public Publisher showPublisher() {
		Publisher publisher = new Publisher();
		publisher.setIdPublisher(1);
		publisher.setName("UPN");
		return publisher;
	}
	*/
	
}
