package com.grupo1.aplicacionweb.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "cartas")
public class Carta implements Serializable {

    private static long serialVersionUID = -7819236374992397102L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date semana;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(
            name = "carta_receta_lunes",
            joinColumns = {@JoinColumn(name = "carta_id")},
            inverseJoinColumns = {@JoinColumn(name = "receta_id")})
    private List<Receta> lunes = new ArrayList<>();
    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(
            name = "carta_receta_martes",
            joinColumns = {@JoinColumn(name = "carta_id")},
            inverseJoinColumns = {@JoinColumn(name = "receta_id")})
    private List<Receta> martes = new ArrayList<>();
    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(
            name = "carta_receta_miercoles",
            joinColumns = {@JoinColumn(name = "carta_id")},
            inverseJoinColumns = {@JoinColumn(name = "receta_id")})
    private List<Receta> miercoles = new ArrayList<>();
    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(
            name = "carta_receta_jueves",
            joinColumns = {@JoinColumn(name = "carta_id")},
            inverseJoinColumns = {@JoinColumn(name = "receta_id")})
    private List<Receta> jueves = new ArrayList<>();
    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(
            name = "carta_receta_viernes",
            joinColumns = {@JoinColumn(name = "carta_id")},
            inverseJoinColumns = {@JoinColumn(name = "receta_id")})
    private List<Receta> viernes = new ArrayList<>();
    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(
            name = "carta_receta_sabado",
            joinColumns = {@JoinColumn(name = "carta_id")},
            inverseJoinColumns = {@JoinColumn(name = "receta_id")})
    private List<Receta> sabado = new ArrayList<>();
    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(
            name = "carta_receta_domingo",
            joinColumns = {@JoinColumn(name = "carta_id")},
            inverseJoinColumns = {@JoinColumn(name = "receta_id")})
    private List<Receta> domingo = new ArrayList<>();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getSemana() {
        return semana;
    }

    public void setSemana(Date semana) {
        this.semana = semana;
    }

    public List<Receta> getLunes() {
        return lunes;
    }

    public void setLunes(List<Receta> lunes) {
        this.lunes = lunes;
    }

    public List<Receta> getMartes() {
        return martes;
    }

    public void setMartes(List<Receta> martes) {
        this.martes = martes;
    }

    public List<Receta> getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(List<Receta> miercoles) {
        this.miercoles = miercoles;
    }

    public List<Receta> getJueves() {
        return jueves;
    }

    public void setJueves(List<Receta> jueves) {
        this.jueves = jueves;
    }

    public List<Receta> getViernes() {
        return viernes;
    }

    public void setViernes(List<Receta> viernes) {
        this.viernes = viernes;
    }

    public List<Receta> getSabado() {
        return sabado;
    }

    public void setSabado(List<Receta> sabado) {
        this.sabado = sabado;
    }

    public List<Receta> getDomingo() {
        return domingo;
    }

    public void setDomingo(List<Receta> domingo) {
        this.domingo = domingo;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "id=" + id +
                ", semana=" + semana +
                ", lunes=" + lunes +
                ", martes=" + martes +
                ", miercoles=" + miercoles +
                ", jueves=" + jueves +
                ", viernes=" + viernes +
                ", sabado=" + sabado +
                ", domingo=" + domingo +
                '}';
    }
}
