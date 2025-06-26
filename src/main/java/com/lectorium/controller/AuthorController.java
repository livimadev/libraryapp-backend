package com.lectorium.controller;

import com.lectorium.dto.AuthorDTO;
import com.lectorium.model.Author;
import com.lectorium.service.IAuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> findAll() throws Exception{
        List<AuthorDTO> list = service.findAll().stream().map(this::converToDto).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> findById(@PathVariable("id") Integer id) throws Exception{
        AuthorDTO obj = converToDto(service.findById(id));
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody AuthorDTO dto) throws Exception{
        Author obj = service.save(convertToEntity(dto));

        // location: http://localhost:9090/books/{id}
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdAuthor()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody AuthorDTO dto) throws Exception{
        Author obj = service.update(convertToEntity(dto),id);
        AuthorDTO dto1= converToDto(obj);
        return ResponseEntity.ok(dto1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id)
            throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private AuthorDTO converToDto(Author obj){
        return modelMapper.map(obj, AuthorDTO.class);
    }

    private Author convertToEntity(AuthorDTO dto){
        return modelMapper.map(dto, Author.class);
    }
}
