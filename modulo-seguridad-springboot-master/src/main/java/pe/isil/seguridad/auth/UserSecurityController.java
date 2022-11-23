package pe.isil.seguridad.auth;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserSecurityController {


    @Autowired UserSecurityService userSecurityService;

    @GetMapping("/adduserauth")
    public String addUser(){
        return  "security/register";
    }

    @GetMapping("/recoverauth")
    public String recover(){
        return  "security/recoverPassword";
    }




    @GetMapping({"/", "/index","/login"})
    public String login(){
        return "security/login";
    }




    @PostMapping("/adduserauth")
    //Model Attirubte es un objeto con el alias name "authusr, el mismo q es dado por el html, el Model q se agrega es para poder pasarle el atributo a otro html"
    public String addUser(@ModelAttribute(name = "authuser") UserSecurity userSecurity, Model model){


      UserSecurity user =  userSecurityService.addUserSecurity(userSecurity);
        return "redirect:/login";
    }


    @PostMapping("/login")
        public String login(@ModelAttribute(name = "authuser") UserSecurity userSecurity, Model model ){

        UserSecurity user = userSecurityService.findUserSecurity(userSecurity.getEmail(), userSecurity.getPassword());

        if(user==null){
            model.addAttribute("resp", "Credencial incorrectas o usuario no exite");
        }else {
            model.addAttribute("resp", "Bienvenido".concat(user.getName()));
        }

        return  "index";
    }

    @PostMapping("/recoverPassword")
        public String recover(@ModelAttribute(name = "recover") UserSecurity  userSecurity, Model model ){

        UserSecurity user = userSecurityService.findUserSecurityByMail(userSecurity.getEmail());

        if(user==null){


            model.addAttribute("resp", "No existe una cuenta con ese correo");
        }else {

            user.setPassword(userSecurity.getPassword());
            userSecurityService.updateSecurity(user);

            model.addAttribute("resp", "Password actualizada");
        }



        return  "index";
    }

}
