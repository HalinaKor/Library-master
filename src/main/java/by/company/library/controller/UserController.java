package by.company.library.controller;

import by.company.library.configuration.MyUserDetails;
import by.company.library.domain.dbo.UserEntity;
import by.company.library.domain.dto.UserDto;
import by.company.library.service.UserService;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    @GetMapping("/home")
    public String currentUser (HttpServletRequest request,
                               Authentication authentication, Model model) {
        if (authentication != null) {
            MyUserDetails userAuth = (MyUserDetails) authentication.getPrincipal();
            UserEntity user = service.getCurrentUser(userAuth);

            HttpSession session = request.getSession(true);
            model.addAttribute("users", user);
        }
        return "profile";
    }

}
