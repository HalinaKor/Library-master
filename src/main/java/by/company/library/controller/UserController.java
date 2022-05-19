package by.company.library.controller;

import by.company.library.domain.dbo.UserEntity;
import by.company.library.domain.dto.BookDto;
import by.company.library.domain.dto.UserDto;
import by.company.library.service.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "login";
    }

    @PostMapping("/home_page")
    public String greetingSubmit(@ModelAttribute UserDto userDto, Model model) {


        model.addAttribute("passportNo", userDto.getPassportNo());
        model.addAttribute("password", userDto.getPassword());

        userDto = service.getUserByPassport(userDto.getPassportNo());
        //set user as a model attribute to pre-populate the form
        model.addAttribute("users", userDto);
        return "profile";
     /* return "user_page";*/
    }

    @GetMapping("/showFormForAddUser")
    public String showFormForAddUser(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("users", userDto);
        return "create_account";
    }

    @PostMapping("/save")
    public String saveUsers(@ModelAttribute("users") UserDto userDto){
        // save the user
        service.add(userDto);
        return "redirect:/users/login";
    }

    @GetMapping("/profile")
    public String profile(@ModelAttribute UserDto userDto, Model model) {

       /* userDto = service.getUserByPassport(userDto.getPassportNo());*/

        model.addAttribute("users", userDto);
        return "profile";

    }




}
