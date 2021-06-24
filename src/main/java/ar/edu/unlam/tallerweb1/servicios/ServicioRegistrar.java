package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioRegistrar {

    void crearUsuario(Usuario usuario);

    Usuario buscarloPor(Long id);
}
