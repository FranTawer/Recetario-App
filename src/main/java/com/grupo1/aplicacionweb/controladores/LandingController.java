package com.grupo1.aplicacionweb.controladores;

import com.grupo1.aplicacionweb.entidades.Usuario;
import com.grupo1.aplicacionweb.repositorios.UsuarioDao;
import com.grupo1.aplicacionweb.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
@RequestMapping("/inicio")
public class LandingController {
    @Autowired
    private UsuarioDao usuarioDao;

    @GetMapping("/")
    public String landing(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Usuario usuario = usuarioDao.findByEmail(userDetails.getUsername());
            model.addAttribute("nombreUsuario", usuario.getNombre());
        }
        model.addAttribute("titulo", "Inicio");
        return "/main/landing";
    }

}
