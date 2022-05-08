package by.company.library.repository;

import by.company.library.domain.dbo.FineEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FineRepository extends PagingAndSortingRepository<FineEntity, Integer> {
}
