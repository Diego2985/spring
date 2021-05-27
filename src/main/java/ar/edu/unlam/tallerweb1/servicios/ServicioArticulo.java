package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Articulo;

public interface ServicioArticulo {

    Articulo verArticulo(long id) throws Exception;
}
