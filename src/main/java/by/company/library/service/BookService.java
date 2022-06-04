package by.company.library.service;

import by.company.library.domain.dbo.BookEntity;
import by.company.library.domain.dto.BookDto;
import by.company.library.domain.mapping.BookMapper;
import by.company.library.exception.api.BookNotFoundException;
import by.company.library.repository.BookRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository repository;
    private final BookMapper mapper;

    public BookService(BookRepository repository, BookMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<BookDto> getAll() {
        var bookEntities = repository.findAll();
        var books = new ArrayList<BookDto>();
        bookEntities.forEach(entity -> books.add(mapper.fromDbo(entity)));
        return books;
    }

    public BookDto getById(String isbn) {
        final BookEntity bookEntity = repository.findById(isbn).orElseThrow(BookNotFoundException::new);
        return mapper.fromDbo(bookEntity);
    }

    public BookDto add(BookDto bookDto) {
        var entity = repository.save(mapper.toDbo(bookDto));
        return mapper.fromDbo(entity);
    }

    public void deleteById(String isbn){
        repository.deleteById(isbn);
    }
}
