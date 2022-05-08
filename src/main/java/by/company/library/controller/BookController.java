package by.company.library.controller;

import by.company.library.domain.dto.BookDto;
import by.company.library.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String getAll(Model model) {
        List<BookDto> books = service.getAll();
        model.addAttribute("books", books);
        return "list_books";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        BookDto bookDto = new BookDto();
        model.addAttribute("books", bookDto);
        return "book_form";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("isbn") String isbn, Model theModel) {
        //get the book from the service
        BookDto bookDto = service.getById(isbn);
        //set book as a model attribute to pre-populate the form
        theModel.addAttribute("books", bookDto);
        return "book_form";
    }
    @PostMapping("/save")
    public String saveBook(@ModelAttribute("books") BookDto bookDto) {
        // save the book
        service.add(bookDto);
        // use a redirect to prevent duplicate submissions
        return "redirect:/books/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("isbn") String isbn){
        service.deleteById(isbn);
        return "redirect:/books/list";
    }

    @GetMapping("/get")
    public BookDto getById(String isbn) {
        return service.getById(isbn);
    }
}
