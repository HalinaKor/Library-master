package by.company.library.service;

import by.company.library.domain.dbo.UserEntity;
import by.company.library.domain.dto.UserDto;
import by.company.library.domain.mapping.UserMapper;
import by.company.library.exception.business.UserNotValidException;
import by.company.library.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserService(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public UserDto getUserByPassport(String passportNo){
        final UserEntity userEntity = repository.findByPassportNo(passportNo);
        return mapper.fromDbo(userEntity);
    }

    public UserDto add(UserDto userDto) throws UserNotValidException {
        var entity = repository.save(mapper.toDbo(userDto));
        return mapper.fromDbo(entity);

    }

    public UserDto getUserNameByPassportN(String passportNo){
        final UserEntity userEntity1 = repository.findUserNameByPassport(passportNo);
        return mapper.fromDbo(userEntity1);
    }
}
