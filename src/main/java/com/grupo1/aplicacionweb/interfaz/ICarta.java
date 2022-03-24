package com.grupo1.aplicacionweb.interfaz;

import com.grupo1.aplicacionweb.entidades.Carta;
import com.grupo1.aplicacionweb.excepciones.ErrorServicio;

import java.util.List;

public interface ICarta {
    public List<Carta> listar();
    public void eliminar(Integer id) throws ErrorServicio;
    public void crear(Carta carta) throws ErrorServicio;
    public Carta findById(Integer id);
}
