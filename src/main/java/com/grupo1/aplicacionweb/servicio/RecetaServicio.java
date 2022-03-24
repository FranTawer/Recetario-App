package com.grupo1.aplicacionweb.servicio;

import com.grupo1.aplicacionweb.entidades.Receta;
import com.grupo1.aplicacionweb.enumeraciones.CategoriaPlato;
import com.grupo1.aplicacionweb.interfaz.IReceta;
import com.grupo1.aplicacionweb.repositorios.RecetaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecetaServicio implements IReceta {
    @Autowired
    private RecetaDao recetaDao;
    @Override
    public List<Receta> listar() {
        return recetaDao.findAll();
    }

    @Override
    public void eliminar(Integer id) {
        recetaDao.deleteById(id);
    }

    @Override
    public void crear(Receta receta) {

        recetaDao.save(receta);
    }

    @Override
    public Receta findById(Integer id) {
        return recetaDao.findById(id).orElse(null);
    }

    @Override
    public List<Receta> listarPorCategoria(CategoriaPlato categoria) {
        return recetaDao.buscarPorCategoria(categoria);
    }


}
