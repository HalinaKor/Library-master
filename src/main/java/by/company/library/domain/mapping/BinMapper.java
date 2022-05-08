package by.company.library.domain.mapping;

import by.company.library.domain.dbo.BinEntity;
import by.company.library.domain.dto.BinDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BinMapper {
    private final ModelMapper mapper;

    public List<BinDto> fromListDbo(List<BinEntity> binEntityList){
        return binEntityList.stream()
                .map(this::fromDbo)
                .collect(Collectors.toList());
    }

    public BinDto fromDbo(BinEntity binEntity) {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        return mapper.map(binEntity, BinDto.class);
    }

    public BinEntity toDbo(BinDto binDto){
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        return mapper.map(binDto, BinEntity.class);
    }
}
