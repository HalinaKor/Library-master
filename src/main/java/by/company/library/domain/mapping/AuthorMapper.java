package by.company.library.domain.mapping;

import by.company.library.domain.dbo.AuthorEntity;
import by.company.library.domain.dto.AuthorDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AuthorMapper {

    private final ModelMapper mapper;

    public List<AuthorDto> fromListDbo(List<AuthorEntity> authorEntityList){
        return authorEntityList.stream()
                .map(this::fromDbo)
                .collect(Collectors.toList());
    }

    public AuthorDto fromDbo(AuthorEntity authorEntity){
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        return mapper.map(authorEntity, AuthorDto.class);
    }

    public AuthorEntity toDbo(AuthorDto authorDto){
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        return mapper.map(authorDto, AuthorEntity.class);
    }
}
