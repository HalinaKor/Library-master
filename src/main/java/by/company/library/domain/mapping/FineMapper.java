package by.company.library.domain.mapping;

import by.company.library.domain.dbo.FineEntity;
import by.company.library.domain.dto.FineDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FineMapper {

    private final ModelMapper mapper;

    public List<FineDto> fromListDbo(List<FineEntity> fineEntityList){
        return fineEntityList.stream()
                .map(this::fromDbo)
                .collect(Collectors.toList());
    }

    public FineDto fromDbo(FineEntity fineEntity){
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        return mapper.map(fineEntity, FineDto.class);
    }

    public FineEntity toDbo(FineDto fineDto){
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        return mapper.map(fineDto, FineEntity.class);
    }
}
