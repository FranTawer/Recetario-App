package com.grupo1.aplicacionweb.interfaz;

import com.grupo1.aplicacionweb.entidades.Usuario;
import com.grupo1.aplicacionweb.excepciones.ErrorServicio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUsuario {

  public List<Usuario> listar();
  public void eliminar(Integer id);
  public void crear(Usuario usuario) throws ErrorServicio;
  public Usuario findById(Integer id);
  public void cambiarPass(Usuario usuario);

}