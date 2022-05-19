package by.company.library.domain.dbo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "book_movement")
public class BookMovementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "User_Id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "Book_ISBN", nullable = false)
    private BookEntity book;

    @ManyToOne
    @JoinColumn(name = "Bin_Id", nullable = false)
    private BinEntity bin;

    private int quantity;

    private Date issueDate;

    private Date returnedDate;

    private Date realReturnedDate;

    private boolean returned;

    private boolean expired;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Fine_Id", referencedColumnName = "ID")
    private FineEntity fine;




}
