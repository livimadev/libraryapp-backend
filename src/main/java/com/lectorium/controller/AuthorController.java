package com.lectorium.controller;

import com.lectorium.model.Author;
import com.lectorium.service.IAuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthorController {
    private final IAuthorService service;

    @GetMapping
    public ResponseEntity<List<Author>> findAll() throws Exception{
        List<Author> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable("id") Integer id) throws Exception{
        Author obj =  service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Author> save(@RequestBody Author author) throws Exception{
        Author obj =  service.save(author);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdAuthor()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> update(@PathVariable("id") Integer id, @RequestBody Author author) throws Exception{
        Author obj =  service.update(author, id);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id)
            throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
