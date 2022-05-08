package by.company.library.repository;

import by.company.library.domain.dbo.AuthorEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository  extends PagingAndSortingRepository<AuthorEntity, Integer> {

    List<AuthorEntity> findAllByNameAndSurname(String name, String surname);
}
