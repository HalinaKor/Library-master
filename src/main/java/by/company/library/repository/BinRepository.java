package by.company.library.repository;

import by.company.library.domain.dbo.BinEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BinRepository extends PagingAndSortingRepository<BinEntity, Integer> {
}
