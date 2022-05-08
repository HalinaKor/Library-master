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
public class BookMovementDto {

    private UserDto userDto;
    private BookDto bookDto;
    private BinDto binDto;
    private FineDto fineDto;
    private int quantity;
    private Date issueDate;
    private Date returnedDate;
    private Date realReturnedDate;
    private boolean returned;
    private boolean expired;
}
