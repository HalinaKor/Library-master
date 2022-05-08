package by.company.library.service;

import by.company.library.domain.dbo.AuthorEntity;
import by.company.library.domain.dto.AuthorDto;
import by.company.library.domain.mapping.AuthorMapper;
import by.company.library.exception.api.AuthorNotFoundException;
import by.company.library.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    public final AuthorRepository repository;
    private final AuthorMapper mapper;

    public AuthorService(AuthorRepository repository, AuthorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<AuthorDto> getAll(){
        var authorEntities = repository.findAll();
        var authors = new ArrayList<AuthorDto>();
        authorEntities.forEach(entity -> authors.add(mapper.fromDbo(entity)));
        return authors;
    }

    public List<AuthorDto> getByNameAndSurname(String name, String surname){
        final List<AuthorEntity> authorEntities = repository.findAllByNameAndSurname(name, surname);
        return mapper.fromListDbo(authorEntities);
    }

    public AuthorDto add(AuthorDto authorDto){
        var entity = repository.save(mapper.toDbo(authorDto));

        return mapper.fromDbo(entity);
    }

    public AuthorDto getById(int id){
        final AuthorEntity authorEntity = repository.findById(id).orElseThrow(AuthorNotFoundException::new);
        return mapper.fromDbo(authorEntity);
    }

    public void deleteById(int id){
        repository.deleteById(id);
    }
}
