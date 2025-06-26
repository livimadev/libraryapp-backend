package com.lectorium.config;

import com.lectorium.dto.BookDTO;
import com.lectorium.model.Book;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean(name = "defaultMapper")
    public ModelMapper defaultMapper(){
        return new ModelMapper();
    }

    @Bean(name = "bookMapper")
    public ModelMapper boolMapper(){
        ModelMapper modelMapper = new ModelMapper();

        // Escritura
        modelMapper.createTypeMap(BookDTO.class, Book.class)
                //.addMapping(e->e.getTitulo(), (dest,v) ->dest.setTitle((String)v))
                .addMapping(BookDTO::getTitulo, (dest,v) ->dest.setTitle((String)v))
                .addMapping(BookDTO::getSubtitulo, (dest,v) ->dest.setSubtitle((String)v));

        // Lectura
        modelMapper.createTypeMap(Book.class, BookDTO.class)
                .addMapping(Book::getTitle, (dest,v)->dest.setTitulo((String)v))
                .addMapping(Book::getSubtitle, (dest,v)->dest.setSubtitulo((String)v));
        return modelMapper;
    }
}