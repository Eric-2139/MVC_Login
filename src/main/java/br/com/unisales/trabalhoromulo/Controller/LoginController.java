package br.com.unisales.trabalhoromulo.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping()
    public ModelAndView getInformacao() {
        return new ModelAndView("informacoes");
    }
    
    @GetMapping("/login")
    public ModelAndView getLogin() {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    @PostMapping("/login")
    public ModelAndView postLogin(String usuario, String senha) {
        ModelAndView mv = new ModelAndView("login");
        mv.addObject("usuario", usuario);
        mv.addObject("senha", senha);

        String usuarioFixo = "Usuario";
        String senhaFixo = "123456";

        if (usuario.equals(usuarioFixo) && senha.equals(senhaFixo)) {
            return new ModelAndView("redirect:/boas-vindas"); 
        } else {
           return new ModelAndView("redirect:/error");
        }
    }
    
    @GetMapping("/boas-vindas")
    public ModelAndView getBoasVindas() {
        return new ModelAndView("boas-vindas");
    }

    @GetMapping("/error")
    public ModelAndView getError() {
        return new ModelAndView("error");
    }

}