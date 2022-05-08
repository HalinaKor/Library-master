package by.company.library.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private String passportNo;
    private String name;
    private String surname;
    private Date birthDate;
    private RoleDto roleDto;
    private String phone;
    private String email;
    private String password;
}
