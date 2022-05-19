package by.company.library.repository;


import by.company.library.domain.dbo.BookMovementEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface BookMovementRepository extends PagingAndSortingRepository<BookMovementEntity, String> {

    List<BookMovementEntity> findAllByUser (String passwordNo);

}
