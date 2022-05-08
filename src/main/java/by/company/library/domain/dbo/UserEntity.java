package by.company.library.domain.dbo;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Passport_No")
    private String passportNo;

    @Column(name = "Name")
    private String name;
    @Column(name = "Surname")
    private String surname;

    @Column(name = "Birth_date")
    private Date birthDate;

    @ManyToOne
    @JoinColumn(name = "Role_Id")
    private RoleEntity role;

    private String phone;

    private String email;

    private String password;

    @OneToMany(mappedBy = "user")
    private Set<BookMovementEntity> booksMovement;
}