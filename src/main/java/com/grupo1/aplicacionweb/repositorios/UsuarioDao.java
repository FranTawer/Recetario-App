package com.grupo1.aplicacionweb.repositorios;

import com.grupo1.aplicacionweb.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Integer> {

    @Query("select u from Usuario u where u.email = :email") // JPQL
            public Usuario findByEmail(@Param("email") String email);

}
