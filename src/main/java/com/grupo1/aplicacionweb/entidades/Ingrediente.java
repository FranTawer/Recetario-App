package com.grupo1.aplicacionweb.entidades;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ingredientes")
public class Ingrediente implements Serializable {

    private static long serialVersionUID = 3098791991667236102L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @NotEmpty(message = "Este campo es obligatorio.")
    @Column(name = "nombre")
    private String nombre;

//    @NotEmpty(message = "Este campo es obligatorio.")
    @Column(name = "cantidad")
    private String cantidad;

    @ManyToMany(mappedBy = "ingredientes",cascade = CascadeType.ALL)
    private List<Receta> recetas = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        Ingrediente.serialVersionUID = serialVersionUID;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public List<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(List<Receta> recetas) {
        this.recetas = recetas;
    }
}
