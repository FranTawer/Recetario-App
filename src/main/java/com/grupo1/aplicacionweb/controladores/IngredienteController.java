package com.grupo1.aplicacionweb.controladores;

import com.grupo1.aplicacionweb.entidades.Ingrediente;
import com.grupo1.aplicacionweb.servicio.IngredienteServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import javax.validation.Valid;

@Controller

@RequestMapping("/ingrediente")
public class IngredienteController {
    @Autowired
    private IngredienteServicio ingredienteServicio;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping("/")
    public String listar(Model model) {
        List<Ingrediente> listaIngredientes = ingredienteServicio.listar();
        model.addAttribute("ingredientes", listaIngredientes);
        model.addAttribute("titulo", "Listado Ingredientes");
        model.addAttribute("h1", "Lista de Ingredientes.");
        return "/ingrediente/lista";
    }

    @GetMapping("/crear")
    public String crearIngrediente(Model model) {
        Ingrediente ingrediente = new Ingrediente();
        model.addAttribute("titulo", "Formulario");
        model.addAttribute("h1", "Formulario Ingreso nuevo Ingrediente");
        model.addAttribute("ingrediente", ingrediente);
        return "/ingrediente/nuevo";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute Ingrediente ingrediente, BindingResult result,
            RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "redirect:/ingrediente/crear";
        }
        try {
            ingredienteServicio.crear(ingrediente);
        } catch (Exception e) {
            redirect.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/ingrediente/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Integer id, RedirectAttributes redirect, Model model) {
        if (id == null || ingredienteServicio.findById(id) == null) {
            redirect.addFlashAttribute("error", "Error, no hay un ingrediente con ese ID.");
            return "redirect:/ingrediente/";
        } else {
            model.addAttribute("ingrediente", ingredienteServicio.findById(id));
        }

        return "/ingrediente/editar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id, RedirectAttributes redirect) {
        if (id == null || ingredienteServicio.findById(id) == null) {
            redirect.addFlashAttribute("error", "Error, no hay un ingrediente con ese ID.");
            return "redirect:/ingrediente/";
        } else {
            ingredienteServicio.eliminar(id);
            redirect.addFlashAttribute("success", "Su ingrediente se elimino con exito!");
        }
        return "redirect:/ingrediente/";
    }
}
