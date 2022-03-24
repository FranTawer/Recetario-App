package com.grupo1.aplicacionweb.controladores;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/index")
public class IndexController {

    @GetMapping("/")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout, Model model, Principal principal,
                        RedirectAttributes attribute) {
        if (error != null) {
            model.addAttribute("error", "ERROR DE VALIDACION: Usuario y/o contraseña son incorrectos");
            return "index";
        }
        if (principal != null) {
            attribute.addFlashAttribute("warning", " ATENCION: ya ha iniciado sesión.");
            return "redirect:/";
        }
        if (logout != null) {
            attribute.addFlashAttribute("success", "SESION FINALIZADA CON EXITO.");
            model.addAttribute("success", "SESION FINALIZADA CON EXITO.");
        }

        model.addAttribute("titulo", "Inicio Sesion");

        return "/login/sesion";
    }
}