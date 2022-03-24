package com.grupo1.aplicacionweb.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pasos")
public class Paso implements Serializable {

    private static final long serialVersionUID = -5619102428209059447L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //    @NotNull
    @Column(name = "numero")
    private Integer numero;
    //    @NotEmpty
    @Column(name = "paso")
    private String paso;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "receta_id")
    private Receta receta; // revisar porque persiste null el id de la receta

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getPaso() {
        return paso;
    }

    public void setPaso(String paso) {
        this.paso = paso;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }
}
