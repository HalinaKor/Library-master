package by.company.library.service;



import by.company.library.domain.dbo.BookMovementEntity;
import by.company.library.domain.dbo.UserEntity;
import by.company.library.domain.dto.BookMovementDto;
import by.company.library.domain.mapping.BookMovementMapper;
import by.company.library.repository.BookMovementRepository;
import by.company.library.repository.BookRepository;
import by.company.library.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookMovementService {

    private final BookMovementRepository repository;
    private final BookMovementMapper mapper;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BookMovementService(BookMovementRepository repository, BookMovementMapper mapper,
                               BookRepository bookRepository, UserRepository userRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public List<BookMovementDto> getAll() {
        var bookMovementEntities = repository.findAll();
        var bookMovement = new ArrayList<BookMovementDto>();
        bookMovementEntities.forEach(entity -> bookMovement.add(mapper.fromDbo(entity)));
        return bookMovement;
    }

    // ловить надо юзера или вводить вручную?? может сделать так search для админа, а для юзера только его
    public BookMovementDto getById(UserEntity user) {
        final BookMovementEntity bookMovementEntity = (BookMovementEntity) repository.findAllByUser(user.getPassportNo());
        return mapper.fromDbo(bookMovementEntity);
    }

    public BookMovementDto add(BookMovementDto bookMovementDto) {
        var entity = repository.save(mapper.toDbo(bookMovementDto));
        return mapper.fromDbo(entity);
    }

    public void deleteById(String isbn){
        repository.deleteById(isbn);
    }



}
