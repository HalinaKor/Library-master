package by.company.library.domain.mapping;

import by.company.library.configuration.MyUserDetails;
import by.company.library.domain.dbo.UserEntity;
import by.company.library.domain.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final ModelMapper mapper;

    public List<UserDto> fromListDbo(List<UserEntity> userEntityList){
        return userEntityList.stream()
                .map(this::fromDbo)
                .collect(Collectors.toList());
    }

    public UserDto fromDbo(UserEntity userEntity){
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        return mapper.map(userEntity, UserDto.class);
    }

    public UserEntity toDbo(UserDto userDto){
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        return mapper.map(userDto, UserEntity.class);
    }

}
