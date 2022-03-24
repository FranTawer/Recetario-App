package com.grupo1.aplicacionweb.controladores;

import com.grupo1.aplicacionweb.entidades.Carta;

import com.grupo1.aplicacionweb.entidades.Receta;
import com.grupo1.aplicacionweb.enumeraciones.CategoriaPlato;
import com.grupo1.aplicacionweb.servicio.CartaServicio;
import com.grupo1.aplicacionweb.servicio.RecetaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

@Controller
@RequestMapping("/carta")
public class CartaController {

    @Autowired
    private CartaServicio cartaServicio;

    @Autowired
    private RecetaServicio recetaServicio;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping("/")
    public String listar(Model model) {
        List<Carta> listaCarta = cartaServicio.listar();
        model.addAttribute("cartas", listaCarta);
        model.addAttribute("titulo", "Listado de Cartas");
        model.addAttribute("h1", "Listado de Menús");
        return "/carta/lista";
    }

    @GetMapping("/listaReceta")
    public String listaRecetaCarta(Model model) {
        model.addAttribute("titulo", "Detalle Simple");
        model.addAttribute("h1", "Lista de Recetas");
        List<Receta> listadoRecetas = recetaServicio.listar();
        model.addAttribute("recetas", listadoRecetas);

        return "/carta/listarecetacarta";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/crear")
    public String crearCarta(Model model) {
        Carta carta = new Carta();

        model.addAttribute("titulo", "Formulario");
        model.addAttribute("h1", "Planificación  Menú Semanal");
        model.addAttribute("carta", carta);

        List<Receta> recetasEntradas = recetaServicio.listarPorCategoria(CategoriaPlato.ENTRADA);
        model.addAttribute("recetasEntradas", recetasEntradas);
        List<Receta> recetasPrincpales = recetaServicio.listarPorCategoria(CategoriaPlato.PRINCIPAL);
        model.addAttribute("recetasPrincipales", recetasPrincpales);
        List<Receta> recetasPostres = recetaServicio.listarPorCategoria(CategoriaPlato.POSTRE);
        model.addAttribute("recetasPostres", recetasPostres);

        return "/carta/nuevo";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute Carta carta, RedirectAttributes redirect) {
        List<Receta> listaLunes = new ArrayList<>();
        List<Receta> listaMartes = new ArrayList<>();
        List<Receta> listaMiercoles = new ArrayList<>();
        List<Receta> listaJueves = new ArrayList<>();
        List<Receta> listaViernes = new ArrayList<>();
        List<Receta> listaSabado = new ArrayList<>();
        List<Receta> listaDomingo = new ArrayList<>();
        try {
            // Lunes
            for (Receta aux : carta.getLunes()) {
                if (aux.getId() != null) {
                    listaLunes.add(recetaServicio.findById(aux.getId()));
                }
            }
            System.out.println("llegamos acá -----------------------------------------------------------");

            carta.setLunes(listaLunes);

            // Martes
            for (Receta aux : carta.getMartes()) {
                if (aux.getId() != null) {
                    listaMartes.add(recetaServicio.findById(aux.getId()));
                }
            }

            carta.setMartes(listaMartes);

            // Miercoles
            for (Receta aux : carta.getMiercoles()) {
                if (aux.getId() != null) {
                    listaMiercoles.add(recetaServicio.findById(aux.getId()));
                }
            }
            carta.setMiercoles(listaMiercoles);

            // Jueves
            for (Receta aux : carta.getJueves()) {
                if (aux.getId() != null) {
                    listaJueves.add(recetaServicio.findById(aux.getId()));
                }
            }
            carta.setJueves(listaJueves);

            // Viernes
            for (Receta aux : carta.getViernes()) {
                if (aux.getId() != null) {
                    listaViernes.add(recetaServicio.findById(aux.getId()));
                }
            }
            carta.setViernes(listaViernes);

            // Sabado
            for (Receta aux : carta.getSabado()) {
                if (aux.getId() != null) {
                    listaSabado.add(recetaServicio.findById(aux.getId()));
                }
            }
            carta.setSabado(listaSabado);

            // Domingo
            for (Receta aux : carta.getDomingo()) {
                if (aux.getId() != null) {
                    listaDomingo.add(recetaServicio.findById(aux.getId()));
                }
            }
            carta.setDomingo(listaDomingo);

            if (carta.getId() != null) {
                carta.setSemana(carta.getSemana());
            }

            cartaServicio.crear(carta);
            redirect.addFlashAttribute("success", "Su menu semanal fue creado con exito!");
        } catch (Exception e) {
            redirect.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/carta/";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Integer id, Model model, RedirectAttributes redirect) {
        if (id != null) {
            model.addAttribute("carta", cartaServicio.findById(id));
            List<Receta> recetasEntradas = recetaServicio.listarPorCategoria(CategoriaPlato.ENTRADA);
            model.addAttribute("recetasEntradas", recetasEntradas);
            List<Receta> recetasPrincpales = recetaServicio.listarPorCategoria(CategoriaPlato.PRINCIPAL);
            model.addAttribute("recetasPrincipales", recetasPrincpales);
            List<Receta> recetasPostres = recetaServicio.listarPorCategoria(CategoriaPlato.POSTRE);
            model.addAttribute("recetasPostres", recetasPostres);
        } else {
            redirect.addFlashAttribute("error", "Error con el ID");
            return "redirect:/carta/";
        }
        model.addAttribute("h1", "Editar Menú");
        return "/carta/editar";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable("id") Integer id, Model model, RedirectAttributes redirect) {
        try {
            System.out.println("este es el id de la carta -----------------------------------------------------------------------------------"+id);
            cartaServicio.eliminar(id);
        } catch (Exception e) {
            redirect.addFlashAttribute("error", e.getMessage());
            return "redirect:/carta/";
        }
        return "redirect:/carta/";
    }

}
