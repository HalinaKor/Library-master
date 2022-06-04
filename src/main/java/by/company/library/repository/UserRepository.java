package by.company.library.repository;

import by.company.library.domain.dbo.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, String> {

    UserEntity findByPassportNo(String passportNo);


    Optional<UserEntity> findByNameContaining(String name);

    List<UserEntity> findAllByNameAndSurname(String name, String surname);

    // by mee
    @Query(value = "select u.Passport_No, u.Name, u.Surname from user u where u.Passport_No = ?", nativeQuery = true)
    UserEntity findUserNameByPassport(String passportNo);
}
