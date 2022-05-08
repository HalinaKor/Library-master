package by.company.library.domain.mapping;

import by.company.library.domain.dbo.BookMovementEntity;
import by.company.library.domain.dto.BookMovementDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BookMovementMapper {

    private final ModelMapper mapper;

    public List<BookMovementDto> fromListDbo(List<BookMovementEntity> bookMovementEntityList){
        return bookMovementEntityList.stream()
                .map(this::fromDbo)
                .collect(Collectors.toList());
    }

    public BookMovementDto fromDbo(BookMovementEntity bookMovementEntity){
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        return mapper.map(bookMovementEntity, BookMovementDto.class);
    }

    public BookMovementEntity toDbo(BookMovementDto bookMovementDto){
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        return mapper.map(bookMovementDto, BookMovementEntity.class);
    }
}
