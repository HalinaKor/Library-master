package by.company.library.domain.mapping;

import by.company.library.domain.dbo.BookEntity;
import by.company.library.domain.dto.BookDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BookMapper {

    private final ModelMapper mapper;

    public List<BookDto> fromListDbo(List<BookEntity> bookEntityList) {
        return bookEntityList.stream()
                .map(this::fromDbo)
                .collect(Collectors.toList());
    }

    public BookDto fromDbo(BookEntity bookEntity) {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        return mapper.map(bookEntity, BookDto.class);
    }

    public BookEntity toDbo(BookDto bookDto) {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        return mapper.map(bookDto, BookEntity.class);
    }
}
