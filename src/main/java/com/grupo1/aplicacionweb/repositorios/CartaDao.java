package com.grupo1.aplicacionweb.repositorios;

import com.grupo1.aplicacionweb.entidades.Carta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaDao extends JpaRepository<Carta,Integer> {

}
