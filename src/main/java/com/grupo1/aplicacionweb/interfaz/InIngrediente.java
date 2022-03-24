package com.grupo1.aplicacionweb.interfaz;

import java.util.List;

import com.grupo1.aplicacionweb.entidades.Ingrediente;
import com.grupo1.aplicacionweb.excepciones.ErrorServicio;

public interface InIngrediente { 

    public List<Ingrediente> listar();
    public void eliminar(Integer id);
    public void crear(Ingrediente ingrediente) throws ErrorServicio;
    public Ingrediente findById(Integer id);
}
