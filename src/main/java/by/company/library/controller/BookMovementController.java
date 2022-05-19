package by.company.library.controller;


import by.company.library.domain.dto.BookMovementDto;
import by.company.library.service.BookMovementService;
import by.company.library.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/bookmovement")
public class BookMovementController {


    private final BookMovementService service;

    public BookMovementController( BookMovementService service) {

        this.service = service;
    }

    @GetMapping("/bookmovementlist")
    public String getAll(Model model) {
        List<BookMovementDto> bookMovement = service.getAll();

       model.addAttribute("bookMovement", bookMovement);
        return "list_bookmovement";
    }

}

