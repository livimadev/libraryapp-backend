package com.lectorium.controller;

import com.lectorium.dto.BookDTO;
import com.lectorium.model.Book;
import com.lectorium.service.IBookService;
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
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final IBookService service;

    @Qualifier("bookMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<BookDTO>> findAll() throws Exception{
        List<BookDTO> list = service.findAll().stream().map(this::converToDto).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> findById(@PathVariable("id") Integer id) throws Exception{
        BookDTO obj = converToDto(service.findById(id));
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody BookDTO dto) throws Exception{
        Book obj = service.save(convertToEntity(dto));

        // location: http://localhost:9090/books/{id}
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdBook()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody BookDTO dto) throws Exception{
        Book obj = service.update(convertToEntity(dto),id);
        BookDTO dto1= converToDto(obj);
        return ResponseEntity.ok(dto1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id)
            throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private BookDTO converToDto(Book obj){
        return modelMapper.map(obj, BookDTO.class);
    }

    private Book convertToEntity(BookDTO dto){
        return modelMapper.map(dto, Book.class);
    }

}
