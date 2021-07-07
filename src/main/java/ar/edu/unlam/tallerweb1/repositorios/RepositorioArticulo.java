package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Articulo;

import java.util.List;

public interface RepositorioArticulo {

    Articulo verArticulo(Long id);

    void guardarArticulo(Articulo articulo);

    List<Articulo> getArticulos();
}
