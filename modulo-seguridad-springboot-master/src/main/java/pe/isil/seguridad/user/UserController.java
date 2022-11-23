package pe.isil.seguridad.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("listUsers",  userService.findAll());
       return "user/index";
    }

    @GetMapping("/register")
    public String register(){
        return "user/register";
    }

    @GetMapping("/update/{id}")
    public String update(){
        return "user/update";
    }
}
