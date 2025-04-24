package com.lectorium.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public ResponseEntity<List<Publisher>> findAll() throws Exception{
		//return service.findAll();
		List<Publisher> list = service.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Publisher> findById(@PathVariable("id") Integer id) throws Exception{
		Publisher obj =  service.findById(id);
		return ResponseEntity.ok(obj);
	}

	@PostMapping
	public ResponseEntity<Publisher> save(@RequestBody Publisher publisher) throws Exception{
		Publisher obj =  service.save(publisher);
		//return ResponseEntity.ok(obj);

		// location: http://localhost:9090/publishers/{id}
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getIdPublisher()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Publisher> update(@PathVariable("id") Integer id, @RequestBody Publisher publisher) throws Exception{
		Publisher obj =  service.update(publisher, id);
		return ResponseEntity.ok(obj);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id)
			throws Exception{
		service.delete(id);
		return ResponseEntity.noContent().build();
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
