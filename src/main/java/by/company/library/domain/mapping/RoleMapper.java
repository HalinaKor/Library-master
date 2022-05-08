package by.company.library.domain.mapping;

import by.company.library.domain.dbo.RoleEntity;
import by.company.library.domain.dto.RoleDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RoleMapper {

    private final ModelMapper mapper;

    public List<RoleDto> fromListDbo(List<RoleEntity> roleEntityList){
        return roleEntityList.stream()
                .map(this::fromDbo)
                .collect(Collectors.toList());
    }

    public RoleDto fromDbo(RoleEntity roleEntity){
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        return mapper.map(roleEntity, RoleDto.class);
    }

    public RoleEntity toDbo(RoleDto roleDto){
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        return mapper.map(roleDto, RoleEntity.class);
    }
}
