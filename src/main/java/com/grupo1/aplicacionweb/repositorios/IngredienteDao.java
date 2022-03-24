package com.grupo1.aplicacionweb.repositorios;

import com.grupo1.aplicacionweb.entidades.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IngredienteDao extends JpaRepository<Ingrediente,Integer> {
}
