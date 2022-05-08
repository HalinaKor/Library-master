package by.company.library.controller;

import by.company.library.domain.dto.AuthorDto;
import by.company.library.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String getAll(Model model){
        List<AuthorDto> authors = service.getAll();
        model.addAttribute("authors", authors);
        return "list_authors";
    }

    @GetMapping("/getById")
    public AuthorDto getById(int id) {
        return service.getById(id);
    }

    @GetMapping("/getByNameAndSurname")
    public List<AuthorDto> getByNameAndSurname(String name, String surname){
        return service.getByNameAndSurname(name, surname);
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        AuthorDto authorDto = new AuthorDto();
        model.addAttribute("authors", authorDto);
        return "author_form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") int id, Model model){
        AuthorDto authorDto = service.getById(id);
        model.addAttribute("authors" , authorDto);
        return "author_form";
    }

    @PostMapping("/save")
    public String saveAuthor(@ModelAttribute("authors") AuthorDto authorDto){
        service.add(authorDto);
        return "redirect:/authors/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam ("id") int id){
        service.deleteById(id);
        return "redirect:/authors/list";
    }

}
