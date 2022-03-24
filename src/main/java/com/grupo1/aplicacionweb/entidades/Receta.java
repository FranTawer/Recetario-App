package com.grupo1.aplicacionweb.entidades;

import com.grupo1.aplicacionweb.enumeraciones.CategoriaPlato;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recetas")
public class Receta implements Serializable {

    private static long serialVersionUID = -3210120901686041769L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // @NotEmpty(message = "Este campo es obligatorio.")
    @Column(name = "nombre")
    private String nombre;

    // @NotEmpty(message = "Este campo es obligatorio.")
    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    private CategoriaPlato categoria;

    //    @NotEmpty(message = "Este campo es obligatorio.")
    @Column(name = "foto")
    private String foto;

    // @NotNull (message = "Este campo es obligatorio.")
    @Column(name = "tiempo_coccion")
    private Integer tiempoDeCoccion;

    // @NotNull (message = "Este campo es obligatorio.")
    @Column(name = "tiempo_preparacion")
    private Integer tiempoDePreparacion;

    // @NotNull (message = "Este campo es obligatorio.")
    @Column(name = "tiempo_total")
    private Integer tiempoTotal;

    // @NotNull (message = "Este campo es obligatorio.")
    @Column(name = "porcion")
    private Integer porcion;

    @OneToMany(mappedBy = "receta", cascade = CascadeType.ALL)
    private List<Paso> pasos = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "receta_ingrediente",
            joinColumns = {@JoinColumn(name = "receta_id")},
            inverseJoinColumns = {@JoinColumn(name = "ingrediente_id")})
    private List<Ingrediente> ingredientes = new ArrayList<>();

    @ManyToMany(mappedBy = "lunes", cascade = CascadeType.ALL)
    private List<Carta> cartasLunes = new ArrayList<>();
    @ManyToMany(mappedBy = "martes", cascade = CascadeType.ALL)
    private List<Carta> cartasMartes = new ArrayList<>();
    @ManyToMany(mappedBy = "miercoles", cascade = CascadeType.ALL)
    private List<Carta> cartasMiercoles = new ArrayList<>();
    @ManyToMany(mappedBy = "jueves", cascade = CascadeType.ALL)
    private List<Carta> cartasJueves = new ArrayList<>();
    @ManyToMany(mappedBy = "viernes", cascade = CascadeType.ALL)
    private List<Carta> cartasViernes = new ArrayList<>();
    @ManyToMany(mappedBy = "sabado", cascade = CascadeType.ALL)
    private List<Carta> cartasSabado = new ArrayList<>();
    @ManyToMany(mappedBy = "domingo", cascade = CascadeType.ALL)
    private List<Carta> cartasDomingo = new ArrayList<>();

    @OneToMany(mappedBy = "receta", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Comentario> comentarios = new ArrayList<>();

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        Receta.serialVersionUID = serialVersionUID;
    }

    public Integer getId() {
        return id;
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

    public CategoriaPlato getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaPlato categoria) {
        this.categoria = categoria;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getTiempoDeCoccion() {
        return tiempoDeCoccion;
    }

    public void setTiempoDeCoccion(Integer tiempoDeCoccion) {
        this.tiempoDeCoccion = tiempoDeCoccion;
    }

    public Integer getTiempoDePreparacion() {
        return tiempoDePreparacion;
    }

    public void setTiempoDePreparacion(Integer tiempoDePreparacion) {
        this.tiempoDePreparacion = tiempoDePreparacion;
    }

    public Integer getTiempoTotal() {
        return tiempoTotal;
    }

    public void setTiempoTotal(Integer tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
    }

    public Integer getPorcion() {
        return porcion;
    }

    public void setPorcion(Integer porcion) {
        this.porcion = porcion;
    }

    public List<Paso> getPasos() {
        return pasos;
    }

    public void setPasos(List<Paso> pasos) {
        this.pasos = pasos;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<Carta> getCartasLunes() {
        return cartasLunes;
    }

    public void setCartasLunes(List<Carta> cartasLunes) {
        this.cartasLunes = cartasLunes;
    }

    public List<Carta> getCartasMartes() {
        return cartasMartes;
    }

    public void setCartasMartes(List<Carta> cartasMartes) {
        this.cartasMartes = cartasMartes;
    }

    public List<Carta> getCartasMiercoles() {
        return cartasMiercoles;
    }

    public void setCartasMiercoles(List<Carta> cartasMiercoles) {
        this.cartasMiercoles = cartasMiercoles;
    }

    public List<Carta> getCartasJueves() {
        return cartasJueves;
    }

    public void setCartasJueves(List<Carta> cartasJueves) {
        this.cartasJueves = cartasJueves;
    }

    public List<Carta> getCartasViernes() {
        return cartasViernes;
    }

    public void setCartasViernes(List<Carta> cartasViernes) {
        this.cartasViernes = cartasViernes;
    }

    public List<Carta> getCartasSabado() {
        return cartasSabado;
    }

    public void setCartasSabado(List<Carta> cartasSabado) {
        this.cartasSabado = cartasSabado;
    }

    public List<Carta> getCartasDomingo() {
        return cartasDomingo;
    }

    public void setCartasDomingo(List<Carta> cartasDomingo) {
        this.cartasDomingo = cartasDomingo;
    }

}
