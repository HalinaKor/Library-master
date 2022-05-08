package by.company.library.repository;

import by.company.library.domain.dbo.BookMovementEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMovementRepository extends PagingAndSortingRepository<BookMovementEntity, Integer> {
}
